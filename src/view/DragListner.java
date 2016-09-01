package view;

import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.dnd.DnDConstants;

import java.awt.dnd.DropTargetDragEvent;
import java.awt.dnd.DropTargetDropEvent;
import java.awt.dnd.DropTargetEvent;
import java.awt.dnd.DropTargetListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
//implement abstract method


public class DragListner implements DropTargetListener{
    
    JLabel imageLabel = new JLabel();
    JLabel pathLabel = new JLabel();
    
    public DragListner(JLabel img)
    {
        imageLabel=img;
//        pathLabel=img;
    }
    @Override
    public void dragEnter(DropTargetDragEvent dtde) {

    }

    @Override
    public void dragOver(DropTargetDragEvent dtde) {

    }

    @Override
    public void dropActionChanged(DropTargetDragEvent dtde) {

    }

    @Override
    public void dragExit(DropTargetEvent dte) {

    }

    @Override
    public void drop(DropTargetDropEvent ev) {
        
        ev.acceptDrop(DnDConstants.ACTION_COPY);
        Transferable t = ev.getTransferable();
        DataFlavor[] df = t.getTransferDataFlavors();
        
        for(DataFlavor f:df)
        {
            try {
                if(f.isFlavorJavaFileListType())
                {
                List<File> files =(List<File>) t.getTransferData(f);
                    for(File file : files)
                    {
                        displayImage(file.getPath());
                    }
                }
            } 
            catch (Exception e) {
            }
        }
    }

    private void displayImage(String path) {
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File(path));
        } catch (Exception e) {
        }
        
        ImageIcon icon = new ImageIcon(img);
        imageLabel.setIcon(icon);
//        pathLabel.setText(path);
       
    }

  
    
}
