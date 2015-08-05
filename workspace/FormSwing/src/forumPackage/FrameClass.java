package forumPackage;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class FrameClass extends JFrame{
	private JTextField NameField,RollField;
	private JTextArea AddressField;
	
	private JPanel NamePanel,RollPanel,AddressPanel,HobbyPanel,GenderPanel,SubmissionPanel;
	private JPanel NameFieldPanel, NameLabelPanel,RollLabelPanel,RollFieldPanel;
	private JPanel AddressFieldPanel, AddressLabelPanel,HobbyBoxPanel,HobbyLabelPanel;
	private JPanel GenderLabelPanel,GenderButtonPanel;
	private JPanel ImagePanel,UploadedImagePanel;
	
	private JMenuBar MenuBar = new JMenuBar();
	private JMenu Menu = new JMenu("Option");
	private JMenuItem Open = new JMenuItem("Open");
	private JMenuItem New = new JMenuItem("New");
	
	private JFileChooser Jf;
	
	private BufferedImage img;
	private JLabel Name,Roll,Address,Gender,Hobby,ImageLabel;
	
	private String NameString,RollString,AddressString,HobbyString,GenderString;
	
	private JRadioButton Male,Female;
	
	private JComboBox HobbyBox;
	
	private String[] Hobbies = { "Video Games","Sports","Movies","Songs","Science"};
	private String path;
	
	private JButton Submission,Upload;
	
	private ButtonGroup radioGroup;
	
	private FileInteraction DataIO;
	
	public FrameClass(){
		super("FORM");
		setLayout(new GridLayout(8,1));
		Jf = new JFileChooser();
		path = null;
		MenuHandle();
		ImageUploadHandle();
		NameHandle();
		RollHandle();
		AddressHandle();
		GenderPanelHandle();
		HobbyHandle();
		SubmissionHandle();		
		DataIO = new FileInteraction();
	}
	private void MenuHandle(){
		Menu.add(New);
		Menu.add(Open);
		MenuBar.add(Menu);
		setJMenuBar(MenuBar);
		MenuHandler handler = new MenuHandler();
		New.addActionListener(handler);
		Open.addActionListener(handler);
	}
	
	private void NameHandle(){
		NamePanel = new JPanel();
		NamePanel.setLayout(new GridLayout(1,2));
		NameFieldPanel = new JPanel();
		NameLabelPanel = new JPanel();
		Name = new JLabel("Name");
		NameLabelPanel.add(Name);
		NameField = new JTextField(10);
		NameFieldPanel.add(NameField);
		NamePanel.add(NameLabelPanel);
		NamePanel.add(NameFieldPanel);
		add(NamePanel);
	}
	private void RollHandle(){
		RollPanel = new JPanel();
		RollPanel.setLayout(new GridLayout(1,2));
		RollFieldPanel = new JPanel();
		RollLabelPanel = new JPanel();
		Roll = new JLabel("Roll");
		RollLabelPanel.add(Roll);
		RollField = new JTextField(10);
		RollFieldPanel.add(RollField);
		RollPanel.add(RollLabelPanel);
		RollPanel.add(RollFieldPanel);
		add(RollPanel);
	}
	private void AddressHandle(){
		AddressPanel = new JPanel();
		AddressPanel.setLayout(new GridLayout(1,2));
		AddressFieldPanel = new JPanel();
		AddressLabelPanel = new JPanel();
		Address = new JLabel("Address");
		AddressLabelPanel.add(Address);
		AddressField = new JTextArea(3,10);
		AddressField.setLineWrap(true);
		AddressFieldPanel.add(new JScrollPane(AddressField));
		AddressPanel.add(AddressLabelPanel);
		AddressPanel.add(AddressFieldPanel);
		add(AddressPanel);
	}
	private void HobbyHandle(){
		HobbyString = Hobbies[0];
		HobbyPanel = new JPanel();
		HobbyPanel.setLayout(new GridLayout(1,2));
		HobbyBoxPanel = new JPanel();
		HobbyLabelPanel = new JPanel();
		Hobby = new JLabel("Hobby");
		HobbyLabelPanel.add(Hobby);
		HobbyBox = new JComboBox(Hobbies);
		HobbyBoxPanel.add(HobbyBox);
		HobbyPanel.add(HobbyLabelPanel);
		HobbyPanel.add(HobbyBoxPanel);
		HobbyItemHandler hobbyHandler = new HobbyItemHandler();
		HobbyBox.addItemListener(hobbyHandler);
		add(HobbyPanel);
	}
	private void GenderPanelHandle(){
		GenderPanel = new JPanel();
		GenderLabelPanel = new JPanel();
		GenderButtonPanel = new JPanel();
		GenderPanel.setLayout(new GridLayout(1,2));
		Gender = new JLabel("Gender");
		GenderLabelPanel.add(Gender);
		Male = new JRadioButton("Male",true);
		Female = new JRadioButton("Female",false);
		radioGroup = new ButtonGroup();
		radioGroup.add(Male);
		radioGroup.add(Female);
		GenderButtonPanel.add(Male);
		GenderButtonPanel.add(Female);
		GenderPanel.add(GenderLabelPanel);
		GenderPanel.add(GenderButtonPanel);
		add(GenderPanel);
	}
	private void SubmissionHandle(){
		SubmissionPanel = new JPanel();
		SubmissionPanel.setLayout(new FlowLayout());
		Submission = new JButton("Submit");
		SubmissionPanel.add(Submission);
		SubmitButton sHandler = new SubmitButton();
		Submission.addActionListener(sHandler);
		add(SubmissionPanel);
	}
	private void ImageUploadHandle(){
		Upload = new JButton("Upload");
		ImageLabel = new JLabel();
		UploadedImagePanel = new JPanel();
		UploadedImagePanel.setLayout(new BorderLayout());
		UploadedImagePanel.add(ImageLabel);
		UploadedImagePanel.add(Upload,BorderLayout.SOUTH);
		ImagePanel = new JPanel();
		ImagePanel.setLayout(new BorderLayout());
		ImagePanel.add(UploadedImagePanel, BorderLayout.EAST);
		add(ImagePanel);
		UploadHandler handler = new UploadHandler();
		Upload.addActionListener(handler);
	}
	private class SubmitButton implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent event) {
			if(Male.isSelected()) GenderString = "Male";
			else GenderString = "Female";
			NameString = NameField.getText();
			RollString = RollField.getText();
			AddressString = AddressField.getText();
			HobbyString = String.format("%d",HobbyBox.getSelectedIndex());
			Jf.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES );
			Jf.showSaveDialog(null);
			path = Jf.getSelectedFile().getPath();
			//store = new StoreInfo(NameString,RollString,AddressString,GenderString,HobbyString);
			DataIO.Save(NameString,RollString,AddressString,GenderString,HobbyString,path,img);
			DataIO.print();
		}
		
	}
	private class HobbyItemHandler implements ItemListener{

		@Override
		public void itemStateChanged(ItemEvent event) {
			 if(event.getStateChange() == ItemEvent.SELECTED){
				 //HobbyString = Hobbies[HobbyBox.getSelectedIndex()];
				 HobbyString = String.format("%d", (HobbyBox.getSelectedIndex()));
			 }
		}
		
	}
	private class UploadHandler implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent event) {
			
			Jf.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES );
			Jf.showOpenDialog(null);
			try{
				path = Jf.getSelectedFile().getPath();
				img = null;
				try{
					img = ImageIO.read(new File(path));
				}catch(IOException e){
					System.out.println(e);
				}
				Image imgIcon = img.getScaledInstance(100,50,Image.SCALE_DEFAULT);
				ImageIcon icon = new ImageIcon(imgIcon);
				ImageLabel.setIcon(icon);
			}catch(Exception e){
				System.out.println(e);
			}
		}
		
	}
	private class MenuHandler implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent event) {
			if(event.getSource() == New){
				NameField.setText(null);
				RollField.setText(null);
				AddressField.setText(null);
				ImageLabel.setIcon(null);
			}
			else if(event.getSource() == Open){
				Jf.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES );
				Jf.showOpenDialog(null);
				File FormFile = Jf.getSelectedFile();
				DataIO.Load(FormFile);
				NameField.setText(DataIO.getName());
				RollField.setText(DataIO.getRoll());
				AddressField.setText(DataIO.getAddress());
				HobbyBox.setSelectedIndex(DataIO.getHobby());
				try{
					ImageLabel.setIcon(DataIO.getImage());
				}catch(Exception e){
					System.out.println(e);
				}
			}
		}
		
	}
}
