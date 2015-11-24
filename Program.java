import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Program extends JFrame implements MouseListener
{  
    public static void main( String[] args )
    {
        Program p = new Program();
    }
    
    private Integer numOfOval = 0;
    private String numOfOvalStr;
    private JPanel panel = new JPanel();
    private JLabel startText = new JLabel();
    
    public Program()
    {
        setTitle( "TEST" );
        setSize( 400, 400 );
        setLocationRelativeTo(null);
        startText = new JLabel( "Click Here" );
        getContentPane().add( panel );
        getContentPane().addMouseListener( this );
        panel.add( startText );

        setVisible( true );

        setNumberOfOvals();
        repaint();
        panel.remove( startText );
        
        if (numOfOval == 0)
            panel.add( startText );
        
        
        
        setDefaultCloseOperation( EXIT_ON_CLOSE );
    }
    
    public void paint( Graphics g )
    {
        super.paint( g );
        g.setColor( Color.RED );
        
        int[] position;
        
        for (int c = 30; c < numOfOval + 30; c++)
            g.drawOval( ( ( c + 5 ) * 2 ), ( ( c + 1 ) * 2 ),
                        ( ( c + 10 ) * 4 ), ( ( c + 10 ) * 2 ) );     
    }
    
    
    public void setNumberOfOvals()
    {
        numOfOvalStr = JOptionPane.showInputDialog( "Enter number of ovals" );
        try
        {
            numOfOval = Integer.parseInt( numOfOvalStr );
        }
        catch( NumberFormatException nFEx )
        {
            numOfOval = 0;
        }
                       
        
        
        if ( !( numOfOval < 1 ))
        {
            if ( numOfOval > 20 )
                numOfOval = 20;
        }
    }
    
    @Override
    public void mouseClicked( MouseEvent event )
    {
        setNumberOfOvals();
        repaint();
        
        if ( numOfOval == 0 )
            panel.add( startText );
        else
            panel.remove(  startText );
    }
    
    @Override
    public void mouseEntered( MouseEvent event )
    {
        
    }
    
    @Override
    public void mouseExited( MouseEvent event )
    {
        
    }
    
    @Override
    public void mousePressed( MouseEvent event )
    {
        
    }
    
    @Override
    public void mouseReleased( MouseEvent event )
    {
       
    }
}
