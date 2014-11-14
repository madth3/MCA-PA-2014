package mca.pa2013.img

import java.awt.image.BufferedImage
import java.awt.image.WritableRaster
import java.util.concurrent.ForkJoinPool
import javax.imageio.ImageIO


String srcName = "imagen-01.jpg"
File srcFile = new File(srcName)
BufferedImage srcImage = ImageIO.read(srcFile)

int w = srcImage.width
int h = srcImage.height
println "($w,$h) = ${w*h} pixeles"

int[] src = srcImage.getRGB(0, 0, w, h, null, 0, w)

def lector = new LectorRangoColumnas(src, 0, w-1, h)

def pool = new ForkJoinPool()
def rango = pool.invoke(lector)
println rango

int[] destino = new int[w*h*3]
println destino.length
int marcador = 0;
for (int k = 0; k < src.length; k++) {
    int sVal = src[k] & 0xFF
    int dVal = rango.ajustarValor(sVal)
    (0..2).each{ destino[marcador++] = dVal }
}
BufferedImage destImage = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB)
WritableRaster raster = destImage.getData()
raster.setPixels(0,0,w, h, destino)
