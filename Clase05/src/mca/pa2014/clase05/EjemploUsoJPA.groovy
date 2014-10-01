package mca.pa2014.clase05

import javax.persistence.EntityManagerFactory
import javax.persistence.Persistence
import mca.pa2014.clase05.oad.CustomerJpaController

EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersistenciaPU")

def oadClientes = new CustomerJpaController(emf)
println oadClientes.findCustomerEntities()