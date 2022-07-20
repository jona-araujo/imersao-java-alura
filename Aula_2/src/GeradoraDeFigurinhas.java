import java.io.File;
import java.io.InputStream;
import java.awt.image.BufferedImage;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.Font;

import javax.imageio.ImageIO;

public class GeradoraDeFigurinhas {

    public void cria(InputStream input, String nomeArquivo) throws Exception{ 

        BufferedImage imagemOriginal = ImageIO.read(input);

        int largura = imagemOriginal.getWidth();
        int altura = imagemOriginal.getHeight();
        int novaAltura = altura + 200;

        BufferedImage novaImagem = new BufferedImage(largura, novaAltura, BufferedImage.TRANSLUCENT);

        Graphics2D graphics =(Graphics2D) novaImagem.getGraphics();
        graphics.drawImage(imagemOriginal, 0, 0, null);

        Font font = new Font(Font.SERIF, Font.BOLD, 64);
        graphics.setColor(Color.MAGENTA);
        graphics.setFont(font);

        graphics.drawString("TEXTO", 0, largura / 2);

        ImageIO.write(novaImagem, "png", new File("saida/"+nomeArquivo));






    }
    
}
