package fr.univcotedazur.polytech.si4.fsm.project;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Hashtable;
import java.util.HashMap;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JSeparator;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.*;
import fr.univcotedazur.polytech.si4.fsm.project.drinkfactorymachine.DrinkFactoryMachineStatemachine;
import fr.univcotedazur.polytech.si4.fsm.project.drinkfactorymachine.IDrinkFactoryMachineStatemachine.SCInterfaceListener;





class DrinkFactoryMachineImplementation implements SCInterfaceListener {
	DrinkFactoryMachine theMachine;
	public DrinkFactoryMachineImplementation(DrinkFactoryMachine dfm) {
    	theMachine = dfm; 
    }

	@Override
	public void onDoResetRaised() {
		// TODO Auto-generated method stub
		
		theMachine.drinkType="";
		theMachine.nfcInfo="";
		theMachine.pay=0;
		theMachine.sugarSlider.setValue(1);
		theMachine.sizeSlider.setValue(1);
		theMachine.temperatureSlider.setValue(2);
		theMachine.progressBar.setValue(0);
		theMachine.currentProgress=0;
		theMachine.theFSM.setPay(0);
		theMachine.theFSM.setPrice(0);
		//theMachine.messagesToUser.setText("Hello Sir/Lady,Please choose the drink");
		theMachine.timer1.stop();
		
	}




	@Override
	public void onDoPrepareRaised() {
		// TODO Auto-generated method stub
	
		ActionListener every10=new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(theMachine.currentProgress<100)
                    theMachine.currentProgress+=10;
                theMachine.progressBar.setValue(theMachine.currentProgress);
            }
        };
        theMachine.timer1=new Timer(1500,every10);
        theMachine.timer1.start();
        if(theMachine.currentProgress==100)
            theMachine.timer1.stop();
		
	}



	@Override
	public void onDoCaculateRaised() {
		// TODO Auto-generated method stub
		theMachine.theFSM.setPay(theMachine.pay);
		theMachine.messagesToUser.setText("<html>Dear Sir/Lady<br>your have paid "+theMachine.pay);
		System.out.println(theMachine.pay);
		System.out.print(theMachine.theFSM.getPrice());
	}

	@Override
	public void onDoChangeTypeRaised() {
		// TODO Auto-generated method stub
		theMachine.messagesToUser.setText("<html>Hello Sir/Lady<br>you have choosed the drink of "+theMachine.drinkType);
		
	}

	@Override
	public void onDoModify1Raised() {
		// TODO Auto-generated method stub
		theMachine.messagesToUser.setText("<html>Dear Sir/Lady<br>the grade sweetness of your drink is "+theMachine.sugarSlider.getValue());
	}

	@Override
	public void onDoModify2Raised() {
		// TODO Auto-generated method stub
		if(theMachine.sizeSlider.getValue()==0)
			theMachine.messagesToUser.setText("<html>Dear Sir/Lady<br>you have choosed the small cup.");
			else if(theMachine.sugarSlider.getValue()==1)
				theMachine.messagesToUser.setText("<html>Dear Sir/Lady<br>you have choosed the middle cup.");
			else 
				theMachine.messagesToUser.setText("<html>Dear Sir/Lady<br>you have choosed the large cup.");
		
	}

	@Override
	public void onDoModify3Raised() {
		// TODO Auto-generated method stub
		theMachine.messagesToUser.setText("<html>Dear Sir/Lady<br>the temperature of your drink is "+theMachine.temperatureSlider.getValue());
	}

	@Override
	public void onDoStoreInfoRaised() {
		// TODO Auto-generated method stub
		theMachine.messagesToUser.setText("<html>Dear Sir/Lady<br>your bank card is successfully recogniezd");
	}

	@Override
	public void onDoChangePriceRaised() {
		// TODO Auto-generated method stub
		if(!theMachine.drinkType.equals("")) {
			if(theMachine.sizeSlider.getValue()==0) {
				theMachine.theFSM.setPrice(theMachine.getPrice(theMachine.drinkType));
				theMachine.messagesToUser1.setText("the price is "+theMachine.getPrice(theMachine.drinkType));
			}
				else if(theMachine.sugarSlider.getValue()==1) {
					theMachine.theFSM.setPrice(theMachine.getPrice(theMachine.drinkType)+0.1);
					theMachine.messagesToUser1.setText("the price is "+theMachine.getPrice(theMachine.drinkType));
				}
				else 
				{
					theMachine.theFSM.setPrice(theMachine.getPrice(theMachine.drinkType)+0.3);
					theMachine.messagesToUser1.setText("the price is "+theMachine.getPrice(theMachine.drinkType));
		
		}
		}
	}

	@Override
	public void onDoRefundRaised() {
		// TODO Auto-generated method stub
		if(theMachine.theFSM.getPay() < theMachine.theFSM.getPrice()) {
			theMachine.messagesToUser.setText("Dear Sir/Lady,your refund is " + theMachine.theFSM.getPay());
		}else if(theMachine.theFSM.getPay() > theMachine.theFSM.getPrice()){
			theMachine.messagesToUser.setText("Dear Sir/Lady,your refund is " + (theMachine.theFSM.getPay()-theMachine.theFSM.getPrice()));
		}
	}

	@Override
	public void onDoShowPricePayRaised() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onDoShowTimeRaised() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onDoResetTimeRaised() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onDoShowDrinkRaised() {
		// TODO Auto-generated method stub
		if(theMachine.isOwnCup==false)
		theMachine.labelForPictures.setIcon(new ImageIcon("./picts/gobeletPolluant.jpg"));
		else
			theMachine.labelForPictures.setIcon(new ImageIcon("./picts/ownCup.jpg"));	
	}



	
}

public class DrinkFactoryMachine extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2030629304432075314L;
	private JPanel contentPane;
	protected JLabel messagesToUser, messagesToUser1,lblCoins, lblSugar, lblSize, lblNfc, labelForPictures, lblTemperature, timeValue;
	protected JSlider sugarSlider, sizeSlider, temperatureSlider;
	protected JButton coffeeButton, expressoButton, teaButton, soupButton, icedTeaButton, money50centsButton,
						money25centsButton, money10centsButton, nfcBiiiipButton, addCupButton, cancelButton;
	protected String drinkType = "",nfcInfo="";
	protected int currentProgress=0,secs=45;
	protected JProgressBar progressBar;
	protected double pay = 0.0;
	protected Timer timer1,myTimer;
	protected boolean isOwnCup=false;
	private HashMap<String,Double> prices = new HashMap<String,Double>();
	protected DrinkFactoryMachineStatemachine theFSM;
	
	/**
	 * @wbp.nonvisual location=311,475
	 */
	private final ImageIcon imageIcon = new ImageIcon();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DrinkFactoryMachine frame = new DrinkFactoryMachine();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	protected void updateTimeValue() {
		timeValue.setText(secs +"s\n");
		repaint();
	}
	
	public double getPrice(String type) {
		if(prices.containsKey(type))
			return prices.get(type);
		return 0;
	}
	/**
	 * Create the frame.
	 */
	public DrinkFactoryMachine() {
		theFSM = new DrinkFactoryMachineStatemachine();
		TimerService timer = new TimerService();
		theFSM.setTimer(timer);
	    theFSM.init();
	    theFSM.enter();
		theFSM.getSCInterface().getListeners().add(
                new DrinkFactoryMachineImplementation(this)
				);
		
		prices.put("Coffee", 0.5);
		prices.put("Tea", 0.5);
		prices.put("Expresso", 0.5);
		prices.put("Soup", 0.5);
		prices.put("Iced Tea", 1.0);
		
		setForeground(Color.DARK_GRAY);
		setFont(new Font("Cantarell", Font.BOLD, 22));
		setBackground(Color.DARK_GRAY);
		setTitle("Drinking Factory Machine");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1000,1100);
		contentPane = new JPanel(null);
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);//添加
		//contentPane.setLayout(null);

		messagesToUser = new JLabel("<html>Hello Sir/Lady<br>Please choose the drink");
		messagesToUser.setFont(new Font("Arial",Font.BOLD,20));
		messagesToUser.setForeground(Color.white);
		messagesToUser.setHorizontalAlignment(SwingConstants.LEFT);
		messagesToUser.setVerticalAlignment(SwingConstants.TOP);
		messagesToUser.setToolTipText("message to the user");
		messagesToUser.setBackground(Color.white);
		messagesToUser.setBounds(200, 50, 250, 300);
		contentPane.add(messagesToUser);
		
		messagesToUser1 = new JLabel("the price is: ");
		messagesToUser1.setFont(new Font("Arial",Font.BOLD,20));
		messagesToUser1.setForeground(Color.white);
		messagesToUser1.setHorizontalAlignment(SwingConstants.LEFT);
		messagesToUser1.setVerticalAlignment(SwingConstants.TOP);
		messagesToUser1.setToolTipText("message to the user");
		messagesToUser1.setBackground(Color.white);
		messagesToUser1.setBounds(200, 220, 250, 150);
		contentPane.add(messagesToUser1);

		lblCoins = new JLabel("Coins");
		lblCoins.setFont(new Font("Arial",Font.BOLD,20));
		lblCoins.setForeground(Color.white);
		lblCoins.setHorizontalAlignment(SwingConstants.CENTER);
		lblCoins.setBounds(840, 20, 65, 20);
		contentPane.add(lblCoins);

		coffeeButton = new JButton("Coffee");
		coffeeButton.setFont(new Font("Arial",Font.BOLD,20));
		coffeeButton.setForeground(Color.DARK_GRAY);
		coffeeButton.setBackground(Color.white);
		coffeeButton.setBounds(20, 50, 150, 40);
		contentPane.add(coffeeButton);
		coffeeButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				drinkType = "Coffee";
				theFSM.raiseType1_btn();
			}
		});
		
		

		expressoButton = new JButton("Expresso");
		expressoButton.setFont(new Font("Arial",Font.BOLD,20));
		expressoButton.setForeground(Color.DARK_GRAY);
		expressoButton.setBackground(Color.white);
		expressoButton.setBounds(20, 110, 150, 40);
		contentPane.add(expressoButton);
		expressoButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				drinkType = "Expresso";	
				theFSM.raiseType1_btn();	
			}
		});

		teaButton = new JButton("Tea");
		teaButton.setFont(new Font("Arial",Font.BOLD,20));
		teaButton.setForeground(Color.DARK_GRAY);
		teaButton.setBackground(Color.white);
		teaButton.setBounds(20, 170, 150, 40);
		contentPane.add(teaButton);
		teaButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				drinkType = "Tea";
				theFSM.raiseType1_btn();
			}
		});
		
		

		soupButton = new JButton("Soup");
		soupButton.setFont(new Font("Arial",Font.BOLD,20));
		soupButton.setForeground(Color.DARK_GRAY);
		soupButton.setBackground(Color.white);
		soupButton.setBounds(20, 230, 150, 40);
		contentPane.add(soupButton);
		soupButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				drinkType = "Soup";
				theFSM.raiseType2_btn();
			}
		});
		
		
		icedTeaButton = new JButton("Iced Tea");
		icedTeaButton.setFont(new Font("Arial",Font.BOLD,20));
		icedTeaButton.setForeground(Color.DARK_GRAY);
		icedTeaButton.setBackground(Color.white);
		icedTeaButton.setBounds(20, 300, 150, 40);
		contentPane.add(icedTeaButton);
		icedTeaButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				drinkType = "Iced Tea";	
				theFSM.raiseType1_btn();
			}
		});

		progressBar = new JProgressBar();
		progressBar.setFont(new Font("Arial",Font.BOLD,20));
		progressBar.setStringPainted(true);
		progressBar.setValue(0);
		progressBar.setForeground(Color.LIGHT_GRAY);
		progressBar.setBackground(Color.white);
		progressBar.setBounds(20, 450, 960, 40);
		contentPane.add(progressBar);
		
        	

		sugarSlider = new JSlider();
		sugarSlider.setValue(1);
		sugarSlider.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		sugarSlider.setBackground(Color.DARK_GRAY);
		sugarSlider.setForeground(Color.white);
		sugarSlider.setPaintTicks(true);
		sugarSlider.setMinorTickSpacing(1);
		sugarSlider.setMajorTickSpacing(1);
		sugarSlider.setMaximum(4);
		sugarSlider.setBounds(480, 80, 320, 55);
		contentPane.add(sugarSlider);
		sugarSlider.addChangeListener(new ChangeListener() {
		      public void stateChanged(ChangeEvent event) {
		    	  theFSM.raiseSli1_btn();
		      }
		});

		sizeSlider = new JSlider();
		sizeSlider.setPaintTicks(true);
		sizeSlider.setValue(1);
		sizeSlider.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		sizeSlider.setBackground(Color.DARK_GRAY);
		sizeSlider.setForeground(Color.white);
		sizeSlider.setMinorTickSpacing(1);
		sizeSlider.setMaximum(2);
		sizeSlider.setMajorTickSpacing(1);
		sizeSlider.setBounds(480, 210, 320, 55);
		contentPane.add(sizeSlider);
		sizeSlider.addChangeListener(new ChangeListener() {
		      public void stateChanged(ChangeEvent event) {
		    	  theFSM.raiseSli2_btn();
		      }
		});

		temperatureSlider = new JSlider();
		temperatureSlider.setPaintLabels(true);
		temperatureSlider.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		temperatureSlider.setValue(2);
		temperatureSlider.setBackground(Color.DARK_GRAY);
		temperatureSlider.setForeground(Color.white);
		temperatureSlider.setPaintTicks(true);
		temperatureSlider.setMajorTickSpacing(1);
		temperatureSlider.setMaximum(3);
		temperatureSlider.setBounds(480, 340, 320, 85);
		temperatureSlider.addChangeListener(new ChangeListener() {
		      public void stateChanged(ChangeEvent event) {
		    	  theFSM.raiseSli3_btn();
		      }
		});

		Hashtable<Integer, JLabel> temperatureTable = new Hashtable<Integer, JLabel>();
		temperatureTable.put(0, new JLabel("20°C"));
		temperatureTable.put(1, new JLabel("35°C"));
		temperatureTable.put(2, new JLabel("60°C"));
		temperatureTable.put(3, new JLabel("85°C"));
		for (JLabel l : temperatureTable.values()) {
			l.setForeground(Color.white);
		}
		temperatureSlider.setLabelTable(temperatureTable);

		contentPane.add(temperatureSlider);

		

		lblSugar = new JLabel("Sugar");
		lblSugar.setFont(new Font("Arial",Font.BOLD,20));
		lblSugar.setForeground(Color.white);
		lblSugar.setBackground(Color.white);
		lblSugar.setHorizontalAlignment(SwingConstants.CENTER);
		lblSugar.setBounds(620, 50, 65, 25);
		contentPane.add(lblSugar);

		lblSize = new JLabel("Size");
		lblSize.setFont(new Font("Arial",Font.BOLD,20));
		lblSize.setForeground(Color.white);
		lblSize.setBackground(Color.white);
		lblSize.setHorizontalAlignment(SwingConstants.CENTER);
		lblSize.setBounds(620, 180, 65, 25);
		contentPane.add(lblSize);
		

		lblTemperature = new JLabel("Temperature");
		lblTemperature.setFont(new Font("Arial",Font.BOLD,20));
		lblTemperature.setForeground(Color.white);
		lblTemperature.setBackground(Color.white);
		lblTemperature.setHorizontalAlignment(SwingConstants.CENTER);
		lblTemperature.setBounds(580, 310, 145, 25);
		contentPane.add(lblTemperature);

		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		lblCoins.setLabelFor(panel);
		panel.setBounds(830, 40, 145, 150);
		contentPane.add(panel);

		money50centsButton = new JButton("0.50 €");
		money50centsButton.setFont(new Font("Arial",Font.BOLD,20));
		money50centsButton.setForeground(Color.DARK_GRAY);
		money50centsButton.setBackground(Color.white);
		panel.add(money50centsButton);
		money50centsButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				pay+=0.5;
				theFSM.raisePay_coins();
			}
		});

		money25centsButton = new JButton("0.25 €");
		money25centsButton.setFont(new Font("Arial",Font.BOLD,20));
		money25centsButton.setForeground(Color.DARK_GRAY);
		money25centsButton.setBackground(Color.white);
		panel.add(money25centsButton);
		money25centsButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				pay+=0.25;
				theFSM.raisePay_coins();
			}
		});
		
		money10centsButton = new JButton("0.10 €");
		money10centsButton.setFont(new Font("Arial",Font.BOLD,20));
		money10centsButton.setForeground(Color.DARK_GRAY);
		money10centsButton.setBackground(Color.white);
		panel.add(money10centsButton);
		money10centsButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				pay+=0.1;
				theFSM.raisePay_coins();
			}
		});
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.DARK_GRAY);
		panel_1.setBounds(830, 230, 145, 60);
		contentPane.add(panel_1);

		nfcBiiiipButton = new JButton("biiip");
		nfcBiiiipButton.setFont(new Font("Arial",Font.BOLD,20));
		nfcBiiiipButton.setForeground(Color.DARK_GRAY);
		nfcBiiiipButton.setBackground(Color.white);
		panel_1.add(nfcBiiiipButton);
		nfcBiiiipButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				theFSM.raiseNfc_btn();;
			}
		});

		lblNfc = new JLabel("NFC");
		lblNfc.setFont(new Font("Arial",Font.BOLD,20));
		lblNfc.setForeground(Color.white);
		lblNfc.setHorizontalAlignment(SwingConstants.CENTER);
		lblNfc.setBounds(825, 210, 90, 25);
		contentPane.add(lblNfc);

		JSeparator separator = new JSeparator();
		separator.setBounds(20, 440, 935, 20);
		contentPane.add(separator);

		addCupButton = new JButton("Add cup");
		addCupButton.setFont(new Font("Arial",Font.BOLD,20));
		addCupButton.setForeground(Color.DARK_GRAY);
		addCupButton.setBackground(Color.white);
		addCupButton.setBounds(70, 550, 150, 40);
		contentPane.add(addCupButton);

		BufferedImage myPicture = null;
		try {
			myPicture = ImageIO.read(new File("./picts/vide2.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		labelForPictures = new JLabel(new ImageIcon(myPicture));
		labelForPictures.setBounds(270, 525, 450, 400);
		contentPane.add(labelForPictures);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.DARK_GRAY);
		panel_2.setBounds(830, 330, 145, 50);
		contentPane.add(panel_2);

		cancelButton = new JButton("Cancel");
		cancelButton.setFont(new Font("Arial",Font.BOLD,20));
		cancelButton.setForeground(Color.DARK_GRAY);
		cancelButton.setBackground(Color.white);
		panel_2.add(cancelButton);
		cancelButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				theFSM.raiseCancle_btn();
			}
		});

		// listeners
		addCupButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				BufferedImage myPicture = null;
				try {
					myPicture = ImageIO.read(new File("./picts/ownCup.jpg"));
				} catch (IOException ee) {
					ee.printStackTrace();
				}
				isOwnCup=true;
				labelForPictures.setIcon(new ImageIcon(myPicture));
			}
		});

		ActionListener doCount = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(secs > 0)
					secs-=1;
				updateTimeValue();
			}
		};
		myTimer = new Timer(1000, doCount);
		
	}
}
