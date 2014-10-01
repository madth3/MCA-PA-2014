/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mca.pa2014.clase05.oad;

import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import mca.pa2014.clase05.entidades.DiscountCode;
import mca.pa2014.clase05.entidades.MicroMarket;
import mca.pa2014.clase05.entidades.PurchaseOrder;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import mca.pa2014.clase05.entidades.Customer;
import mca.pa2014.clase05.oad.exceptions.IllegalOrphanException;
import mca.pa2014.clase05.oad.exceptions.NonexistentEntityException;
import mca.pa2014.clase05.oad.exceptions.PreexistingEntityException;

/**
 *
 * @author jaguilar
 */
public class CustomerJpaController implements Serializable {

    public CustomerJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Customer customer) throws PreexistingEntityException, Exception {
        if (customer.getPurchaseOrderList() == null) {
            customer.setPurchaseOrderList(new ArrayList<PurchaseOrder>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            DiscountCode discountCode = customer.getDiscountCode();
            if (discountCode != null) {
                discountCode = em.getReference(discountCode.getClass(), discountCode.getDiscountCode());
                customer.setDiscountCode(discountCode);
            }
            MicroMarket zip = customer.getZip();
            if (zip != null) {
                zip = em.getReference(zip.getClass(), zip.getZipCode());
                customer.setZip(zip);
            }
            List<PurchaseOrder> attachedPurchaseOrderList = new ArrayList<PurchaseOrder>();
            for (PurchaseOrder purchaseOrderListPurchaseOrderToAttach : customer.getPurchaseOrderList()) {
                purchaseOrderListPurchaseOrderToAttach = em.getReference(purchaseOrderListPurchaseOrderToAttach.getClass(), purchaseOrderListPurchaseOrderToAttach.getOrderNum());
                attachedPurchaseOrderList.add(purchaseOrderListPurchaseOrderToAttach);
            }
            customer.setPurchaseOrderList(attachedPurchaseOrderList);
            em.persist(customer);
            if (discountCode != null) {
                discountCode.getCustomerList().add(customer);
                discountCode = em.merge(discountCode);
            }
            if (zip != null) {
                zip.getCustomerList().add(customer);
                zip = em.merge(zip);
            }
            for (PurchaseOrder purchaseOrderListPurchaseOrder : customer.getPurchaseOrderList()) {
                Customer oldCustomerIdOfPurchaseOrderListPurchaseOrder = purchaseOrderListPurchaseOrder.getCustomerId();
                purchaseOrderListPurchaseOrder.setCustomerId(customer);
                purchaseOrderListPurchaseOrder = em.merge(purchaseOrderListPurchaseOrder);
                if (oldCustomerIdOfPurchaseOrderListPurchaseOrder != null) {
                    oldCustomerIdOfPurchaseOrderListPurchaseOrder.getPurchaseOrderList().remove(purchaseOrderListPurchaseOrder);
                    oldCustomerIdOfPurchaseOrderListPurchaseOrder = em.merge(oldCustomerIdOfPurchaseOrderListPurchaseOrder);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findCustomer(customer.getCustomerId()) != null) {
                throw new PreexistingEntityException("Customer " + customer + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Customer customer) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Customer persistentCustomer = em.find(Customer.class, customer.getCustomerId());
            DiscountCode discountCodeOld = persistentCustomer.getDiscountCode();
            DiscountCode discountCodeNew = customer.getDiscountCode();
            MicroMarket zipOld = persistentCustomer.getZip();
            MicroMarket zipNew = customer.getZip();
            List<PurchaseOrder> purchaseOrderListOld = persistentCustomer.getPurchaseOrderList();
            List<PurchaseOrder> purchaseOrderListNew = customer.getPurchaseOrderList();
            List<String> illegalOrphanMessages = null;
            for (PurchaseOrder purchaseOrderListOldPurchaseOrder : purchaseOrderListOld) {
                if (!purchaseOrderListNew.contains(purchaseOrderListOldPurchaseOrder)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain PurchaseOrder " + purchaseOrderListOldPurchaseOrder + " since its customerId field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (discountCodeNew != null) {
                discountCodeNew = em.getReference(discountCodeNew.getClass(), discountCodeNew.getDiscountCode());
                customer.setDiscountCode(discountCodeNew);
            }
            if (zipNew != null) {
                zipNew = em.getReference(zipNew.getClass(), zipNew.getZipCode());
                customer.setZip(zipNew);
            }
            List<PurchaseOrder> attachedPurchaseOrderListNew = new ArrayList<PurchaseOrder>();
            for (PurchaseOrder purchaseOrderListNewPurchaseOrderToAttach : purchaseOrderListNew) {
                purchaseOrderListNewPurchaseOrderToAttach = em.getReference(purchaseOrderListNewPurchaseOrderToAttach.getClass(), purchaseOrderListNewPurchaseOrderToAttach.getOrderNum());
                attachedPurchaseOrderListNew.add(purchaseOrderListNewPurchaseOrderToAttach);
            }
            purchaseOrderListNew = attachedPurchaseOrderListNew;
            customer.setPurchaseOrderList(purchaseOrderListNew);
            customer = em.merge(customer);
            if (discountCodeOld != null && !discountCodeOld.equals(discountCodeNew)) {
                discountCodeOld.getCustomerList().remove(customer);
                discountCodeOld = em.merge(discountCodeOld);
            }
            if (discountCodeNew != null && !discountCodeNew.equals(discountCodeOld)) {
                discountCodeNew.getCustomerList().add(customer);
                discountCodeNew = em.merge(discountCodeNew);
            }
            if (zipOld != null && !zipOld.equals(zipNew)) {
                zipOld.getCustomerList().remove(customer);
                zipOld = em.merge(zipOld);
            }
            if (zipNew != null && !zipNew.equals(zipOld)) {
                zipNew.getCustomerList().add(customer);
                zipNew = em.merge(zipNew);
            }
            for (PurchaseOrder purchaseOrderListNewPurchaseOrder : purchaseOrderListNew) {
                if (!purchaseOrderListOld.contains(purchaseOrderListNewPurchaseOrder)) {
                    Customer oldCustomerIdOfPurchaseOrderListNewPurchaseOrder = purchaseOrderListNewPurchaseOrder.getCustomerId();
                    purchaseOrderListNewPurchaseOrder.setCustomerId(customer);
                    purchaseOrderListNewPurchaseOrder = em.merge(purchaseOrderListNewPurchaseOrder);
                    if (oldCustomerIdOfPurchaseOrderListNewPurchaseOrder != null && !oldCustomerIdOfPurchaseOrderListNewPurchaseOrder.equals(customer)) {
                        oldCustomerIdOfPurchaseOrderListNewPurchaseOrder.getPurchaseOrderList().remove(purchaseOrderListNewPurchaseOrder);
                        oldCustomerIdOfPurchaseOrderListNewPurchaseOrder = em.merge(oldCustomerIdOfPurchaseOrderListNewPurchaseOrder);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = customer.getCustomerId();
                if (findCustomer(id) == null) {
                    throw new NonexistentEntityException("The customer with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws IllegalOrphanException, NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Customer customer;
            try {
                customer = em.getReference(Customer.class, id);
                customer.getCustomerId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The customer with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            List<PurchaseOrder> purchaseOrderListOrphanCheck = customer.getPurchaseOrderList();
            for (PurchaseOrder purchaseOrderListOrphanCheckPurchaseOrder : purchaseOrderListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Customer (" + customer + ") cannot be destroyed since the PurchaseOrder " + purchaseOrderListOrphanCheckPurchaseOrder + " in its purchaseOrderList field has a non-nullable customerId field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            DiscountCode discountCode = customer.getDiscountCode();
            if (discountCode != null) {
                discountCode.getCustomerList().remove(customer);
                discountCode = em.merge(discountCode);
            }
            MicroMarket zip = customer.getZip();
            if (zip != null) {
                zip.getCustomerList().remove(customer);
                zip = em.merge(zip);
            }
            em.remove(customer);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Customer> findCustomerEntities() {
        return findCustomerEntities(true, -1, -1);
    }

    public List<Customer> findCustomerEntities(int maxResults, int firstResult) {
        return findCustomerEntities(false, maxResults, firstResult);
    }

    private List<Customer> findCustomerEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Customer.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Customer findCustomer(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Customer.class, id);
        } finally {
            em.close();
        }
    }

    public int getCustomerCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Customer> rt = cq.from(Customer.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
