import javax.swing.*;  
import java.awt.*;
import java.awt.event.*;  

/**
 * 
 * Created using Java Swing, this gui visualizes the huffman encoding process. I'm sure there is a way to simplify
 * some of this however this was my first time making a GUI. 
 */
public class GUI{
    JButton originalButton;
    JButton binaryButton;
    JButton bookButton;
    JButton encodedButton;
    JButton frequencyButton;
    JButton decodedButton;

    public void createAndShowGUI(String OGFile, String fBook, String OGBinary, String Book, String EncodedText, String DecodedText){
        JFrame frame = new JFrame("Button Demo");
        
        // Add a title in the Page Start section
        JLabel title = new JLabel("Huffman Encoding", SwingConstants.CENTER);
        Font heading = new Font("Helvetica", Font.BOLD, 20);
        title.setFont(heading);
        title.setForeground(new Color(255,140,0));
        title.setPreferredSize(new Dimension(300, 50));
        title.setOpaque(true);
        title.setBackground(Color.BLACK);
        frame.getContentPane().add(title, BorderLayout.PAGE_START);
        
        
        JPanel pane = new JPanel(new FlowLayout());
        pane.setLayout(new BorderLayout());
        pane.setPreferredSize(new Dimension(600, 600));
        pane.setBackground(Color.BLACK);
        pane.setOpaque(true);
        frame.getContentPane().add(pane, BorderLayout.CENTER);
        
        
        originalButton = new JButton("Original");
        
        frequencyButton = new JButton("Frequency Table");

        binaryButton = new JButton("OG Binary");
        
        bookButton = new JButton("Code Book");

        encodedButton = new JButton("Encoded Text");

        decodedButton = new JButton("Decoded Text");

        JTextArea textArea = new JTextArea(5, 20);
        textArea.append(OGFile);
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setPreferredSize(new Dimension(200,300));
        
        // Adjust the size and color of the start button
        originalButton.setPreferredSize(new Dimension(100, 30));
        originalButton.setBackground(new Color(255,140,0));

        // Adjust the size and color of the stop button
        
        binaryButton.setPreferredSize(new Dimension(200, 30));
        binaryButton.setBackground(new Color(255,140,0));

        bookButton.setPreferredSize(new Dimension (200, 30));
        bookButton.setBackground(new Color(255,140,0));

        encodedButton.setPreferredSize(new Dimension (200, 30));
        encodedButton.setBackground(new Color(255,140,0));

        frequencyButton.setPreferredSize(new Dimension (200, 30));
        frequencyButton.setBackground(new Color(255,140,0));

        decodedButton.setPreferredSize(new Dimension (200, 30));
        decodedButton.setBackground(new Color(255,140,0));

        JPanel ButtonPanel = new JPanel();
        ButtonPanel.add(originalButton);
        ButtonPanel.add(frequencyButton);
        ButtonPanel.add(binaryButton);
        ButtonPanel.add(encodedButton);
        ButtonPanel.add(bookButton);
        ButtonPanel.add(decodedButton);
        ButtonPanel.setBackground(Color.BLACK);

        pane.add(ButtonPanel, BorderLayout.NORTH);
        pane.add(scrollPane, BorderLayout.CENTER);
        
        
        
        //JPanel checkBoxes = new JPanel();
        
        
        // Add the new panel into the flow pane
        
        
        // Show the Frame
        frame.pack();
        
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        WindowListener listener = new WindowAdapter() {
            public void windowClosing(WindowEvent evt) {
               System.exit(0);
            }
         };
         frame.addWindowListener(listener);
        originalButton.addActionListener(new ActionListener() {
            @Override

            public void actionPerformed(ActionEvent e){
                
                textArea.setText(null);
                textArea.append(OGFile);
                textArea.setSelectionStart(0);
                textArea.setSelectionEnd(0);


            }
    });

    binaryButton.addActionListener(new ActionListener() {
        @Override

        public void actionPerformed(ActionEvent e){
            
            textArea.setText(null);
            textArea.setText(OGBinary);
            textArea.setSelectionStart(0);
            textArea.setSelectionEnd(0);

        }
    });

    bookButton.addActionListener(new ActionListener() {
        @Override

        public void actionPerformed(ActionEvent e){
            
            textArea.setText(null);
            textArea.append(Book);
            textArea.setSelectionStart(0);
            textArea.setSelectionEnd(0);

        }
    });

    encodedButton.addActionListener(new ActionListener() {
        @Override

        public void actionPerformed(ActionEvent e){
            
            textArea.setText(null);
            textArea.append(EncodedText);
            textArea.setSelectionStart(0);
            textArea.setSelectionEnd(0);

        }
    });

    frequencyButton.addActionListener(new ActionListener() {
        @Override

        public void actionPerformed(ActionEvent e){
            
            textArea.setText(null);
            textArea.append(fBook);
            textArea.setSelectionStart(0);
            textArea.setSelectionEnd(0);

        }
    });

    decodedButton.addActionListener(new ActionListener() {
        @Override

        public void actionPerformed(ActionEvent e){
            
            textArea.setText(null);
            textArea.append(DecodedText);
            textArea.setSelectionStart(0);
            textArea.setSelectionEnd(0);

        }
    });

}


    public void actionPerformed(ActionEvent e) {
        
        // Check if the Start button was pushed
        if (e.getSource() == originalButton) {
            System.out.println("Start");
        }
        // Check if the Stoop button was pushed
        else if (e.getSource() == binaryButton) {
            System.out.println("Stop");
        }
    }

    WindowListener listener = new WindowAdapter() {
        public void windowClosing(WindowEvent evt) {
           System.exit(0);
        }
     };
    
}
    
   