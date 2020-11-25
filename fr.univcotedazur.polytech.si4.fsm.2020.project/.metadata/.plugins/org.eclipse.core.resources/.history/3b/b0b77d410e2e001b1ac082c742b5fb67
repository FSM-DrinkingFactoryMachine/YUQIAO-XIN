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
import java.math.BigDecimal;
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
	String text = "<html>Hello Sir/Lady<br>Please choose the drink", text1 = "";
	boolean isBiip = false;
	public DrinkFactoryMachineImplementation(DrinkFactoryMachine dfm) {
    	theMachine = dfm; 
    }

	@Override
	public void onDoResetRaised() {
		// TODO Auto-generated method stub
		text = "<html>Hello Sir/Lady<br>Please choose the drink";
		text1 = "";
		isBiip = false;
		theMachine.drinkType = "";
		theMachine.nfcInfo = "";
		theMachine.timer1.stop();
		theMachine.curpay = 0.0;
		theMachine.curprice = 0.0;
		theMachine.sugarSlider.setValue(0);
		theMachine.sizeSlider.setValue(0);
		theMachine.temperatureSlider.setValue(0);
		theMachine.progressBar.setValue(0);
		theMachine.currentProgress = 0;
		theMachine.isOwnCup = false;
		theMachine.messagesToUser.setText(text);
		theMachine.messagesToUser1.setText(text1);
		theMachine.messagesToUser2.setText(text1);
//		theMachine.timeValue.setText("");
		theMachine.labelForPictures.setIcon(new ImageIcon("./picts/vide2.jpg"));
		
	}





	@Override
	public void onDoCaculateRaised() {
		// TODO Auto-generated method stub
		if(theMachine.curpay >= theMachine.curprice && theMachine.curprice != 0.0) {
			theMachine.theFSM.raisePrepare();
		}
	}

	@Override
	public void onDoChangeTypeRaised() {
		// TODO Auto-generated method stub
		theMachine.messagesToUser.setText("<html>Hello Sir/Lady<br>you have choosed the drink of "+theMachine.drinkType);
		
	}

	@Override
	public void onDoModify1Raised() {
		// TODO Auto-generated method stub
		if(theMachine.drinkType!="Soup")
		theMachine.messagesToUser.setText("<html>Dear Sir/Lady<br>the grade sweetness of your drink is "+theMachine.sugarSlider.getValue());
		else
			theMachine.messagesToUser.setText("<html>Dear Sir/Lady<br>the amount of spices of your drink is "+theMachine.spiceSlider.getValue());	
	}

	@Override
	public void onDoModify2Raised() {
		// TODO Auto-generated method stub
		if(theMachine.sizeSlider.getValue()==0)
			theMachine.messagesToUser.setText("<html>Dear Sir/Lady<br>you have choosed the small cup.");
			else if(theMachine.sizeSlider.getValue()==1)
				theMachine.messagesToUser.setText("<html>Dear Sir/Lady<br>you have choosed the middle cup.");
			else 
				theMachine.messagesToUser.setText("<html>Dear Sir/Lady<br>you have choosed the large cup.");
		
	}

	@Override
	public void onDoModify3Raised() {
		// TODO Auto-generated method stub
		if(theMachine.drinkType!="Iced Tea") {
			if(theMachine.temperatureSlider.getValue()==0)
				theMachine.messagesToUser.setText("<html>Dear Sir/Lady<br>the temperature of your drink is 20°C");
			else if(theMachine.temperatureSlider.getValue()==1)
				theMachine.messagesToUser.setText("<html>Dear Sir/Lady<br>the temperature of your drink is 35°C");
			else if(theMachine.temperatureSlider.getValue()==2)
				theMachine.messagesToUser.setText("<html>Dear Sir/Lady<br>the temperature of your drink is 60°C");
			else
				theMachine.messagesToUser.setText("<html>Dear Sir/Lady<br>the temperature of your drink is 85°C");
		
			}
		else {
			if(theMachine.timeSlider.getValue()==0)
				theMachine.messagesToUser.setText("<html>Dear Sir/Lady<br>the refrigerating time of your drink normal");
			else if(theMachine.timeSlider.getValue()==1)
				theMachine.messagesToUser.setText("<html>Dear Sir/Lady<br>the refrigerating time of your drink long");
			
		}
	}

	@Override
	public void onDoStoreInfoRaised() {
		// TODO Auto-generated method stub
		isBiip = true;
		theMachine.messagesToUser.setText("<html>Dear Sir/Lady<br>your bank card is successfully recogniezd");
	}

	@Override
	public void onDoChangePriceRaised() {
		// TODO Auto-generated method stub
		double discount = theMachine.isOwnCup? -0.1 : 0;
		if(!theMachine.drinkType.equals("")) {
			if(theMachine.sizeSlider.getValue()==0) {
				double price = theMachine.getPrice(theMachine.drinkType)+discount;
				BigDecimal b = new BigDecimal(price);
				price = b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
				theMachine.curprice = price;
				theMachine.messagesToUser1.setText("the price is "+price);
			} else if(theMachine.sizeSlider.getValue()==1) {
				double price = theMachine.getPrice(theMachine.drinkType)+discount+0.1;
				BigDecimal b = new BigDecimal(price);
				price = b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
				theMachine.curprice = price;
				theMachine.messagesToUser1.setText("the price is "+price);
			} else {
				double price = theMachine.getPrice(theMachine.drinkType)+discount+0.3;
				BigDecimal b = new BigDecimal(price);
				price = b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
				theMachine.curprice = price;
				theMachine.messagesToUser1.setText("the price is "+price);
			}
		}
	}

	@Override
	public void onDoRefundRaised() {
		// TODO Auto-generated method stub
		theMachine.messagesToUser.setText("");
		theMachine.messagesToUser1.setText("");
		if(theMachine.curpay < theMachine.curprice) {
			theMachine.messagesToUser.setText("<html>Dear Sir/Lady<br>your refund is <br>" + theMachine.curpay);
		}else if(theMachine.curpay > theMachine.curprice){
			double refund = theMachine.curpay - theMachine.curprice;
			BigDecimal b = new BigDecimal(refund);
			refund = b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
			theMachine.messagesToUser.setText("<html>Dear Sir/Lady<br>your refund is <br>" + refund);
		}
	}




	@Override
	public void onDoResetTimeRaised() {
		
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onDoWaitRecoverRaised() {
		// TODO Auto-generated method stub
		theMachine.messagesToUser.setText("<html>waiting for the<br>container to be recovered.");
		theMachine.timer1.stop();
		BufferedImage myPicture = null;
		if(theMachine.isOwnCup==false) {
			try {
				myPicture = ImageIO.read(new File("./picts/gobeletPolluant.jpg"));
			} catch (IOException ee) {
				ee.printStackTrace();
			}
			theMachine.labelForPictures.setIcon(new ImageIcon(myPicture));
		}
			
		else {
			try {
				myPicture = ImageIO.read(new File("./picts/ownCup.jpg"));
			} catch (IOException ee) {
				ee.printStackTrace();
			}
			theMachine.labelForPictures.setIcon(new ImageIcon(myPicture));
			}
		}

	@Override
	public void onDoInitialNfcInfoRaised() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void onDoJudgeTypeRaised() {
		// TODO Auto-generated method stub
		switch(theMachine.drinkType) {
			case "Coffee":
				theMachine.theFSM.raisePr_coffee();
				break;
			case "Expresso":
				theMachine.theFSM.raisePr_expresso();
				break;
			case "Iced Tea":
				theMachine.theFSM.raisePr_icedTea();
				break;
			case "Soup":
				theMachine.theFSM.raisePr_soup();
				break;
			case "Tea":
				theMachine.theFSM.raisePr_tea();
				break;
			default:
				break;
		}
	}

	@Override
	public void onDoSetDosetteRaised() {
		// TODO Auto-generated method stub
//		theMachine.messagesToUser.setText("<html>recovery and<br>positioning of a pod");
//		theMachine.messagesToUser1.setText("");
		if(theMachine.drinkType.equals("Coffee")) {
			theMachine.messagesToUser.setText("<html>waiting for <br>setting dosette.");
			theMachine.controlProgressBar(250, 20);
			theMachine.controlRuningTime(20, "Coffee");
//			theMachine.theFSM.raisePr_coffee();
		}
		else if(theMachine.drinkType.equals("Iced Tea")) {
			theMachine.messagesToUser.setText("<html>waiting for <br>setting dosette.");
			theMachine.controlProgressBar(350, 15);
			theMachine.controlRuningTime(15, "Iced Tea");
			
		}
		
	}

	@Override
	public void onDoHeatWaterRaised() {
		// TODO Auto-generated method stub
//		theMachine.messagesToUser1.setText("<html>start of<br>water heating");
//		theMachine.messagesToUser1.setText("");
//		if(theMachine.drinkType.equals("Coffee")) {
//			theMachine.controlProgressBar(500, 30);
//			if(theMachine.currentProgress == 30) {
//				theMachine.theFSM.raiseNext();
//			}
//		}
		theMachine.messagesToUser1.setText("<html>start of<br>water heating");
	}

	@Override
	public void onDoWaitHeatRaised() {
		// TODO Auto-generated method stub
		theMachine.messagesToUser1.setText("");
		theMachine.messagesToUser.setText("<html>waiting for<br>the right temperature");
			
	}

	@Override
	public void onDoPutCupRaised()  {
		// TODO Auto-generated method stub
//		theMachine.messagesToUser.setText("<html>positioning of the cup");
//		if(theMachine.drinkType.equals("Coffee"))
//			theMachine.controlProgressBar(500, 70);
		
		switch(theMachine.drinkType) {
		case "Coffee":
			theMachine.theFSM.raisePr_coffee();
			break;
		case "Expresso":
			theMachine.theFSM.raisePr_expresso();
			break;
		case "Iced Tea":
			theMachine.theFSM.raisePr_icedTea();
			break;
		case "Soup":
			theMachine.controlProgressBar(200, 35);
			theMachine.controlRuningTime(35, "Soup");
			break;
		case "Tea":
			theMachine.theFSM.raisePr_tea();
			break;
		default:
			break;
	}
		
			
	}

	@Override
	public void onDoAddSugarRaised() {
		// TODO Auto-generated method stub
//		theMachine.messagesToUser.setText("<html>adding sugar");
		if(theMachine.drinkType.equals("Coffee"))
			theMachine.controlProgressBar(250, 100);
	}

	@Override
	public void onDoAddWaterRaised() {
		// TODO Auto-generated method stub
//		theMachine.messagesToUser.setText("<html>flow of water<br>according to correct size");
	}

	@Override
	public void onDoCrushGrainRaised() {
		// TODO Auto-generated method stub
		theMachine.messagesToUser.setText("<html>grain crushing");
		theMachine.controlProgressBar(250, 30);
		theMachine.theFSM.raisePr_expresso();
	}

	@Override
	public void onDoTampGrainRaised() {
		
		theMachine.messagesToUser1.setText("<html>tamping of the grains<br>");
	}

	@Override
	public void onDoSetSachetRaised() {
		// TODO Auto-generated method stub
		theMachine.messagesToUser.setText("<html>recovery and<br>positioning of a sachet");
		theMachine.controlProgressBar(200, 25);
		theMachine.theFSM.raisePr_tea();
	}

	@Override
	public void onDoWaitInfusionRaised() {
		// TODO Auto-generated method stub
		theMachine.controlProgressBar(250, 25);
//		theMachine.messagesToUser.setText("<html>waiting for the infusion");
	}

	@Override
	public void onDoWithdrawSachetRaised() {
		// TODO Auto-generated method stub
//		theMachine.messagesToUser.setText("<html>withdrawal of the sachet");
	}

	@Override
	public void onDoJudgeCupRaised() {
		// TODO Auto-generated method stub
		if(theMachine.isOwnCup==false) {
			theMachine.theFSM.raiseNeedCup();
		}
		else {
			switch(theMachine.drinkType) {
		case "Coffee":
			theMachine.theFSM.raiseNextStep();
			break;
		case "Expresso":
			theMachine.theFSM.raiseNextStep();
			break;
		case "Iced Tea":
			theMachine.theFSM.raiseNextStep();
			break;
		case "Soup":
			theMachine.controlProgressBar(250, 35);
			theMachine.controlRuningTime(35, "Soup");
			break;
		case "Tea":
			theMachine.theFSM.raiseNextStep();
			break;
		default:
			break;
				}
			}
	}

	@Override
	public void onDoSetSoupRaised() {
		// TODO Auto-generated method stub
		theMachine.messagesToUser1.setText("<html>recovery and<br>pouring of a dose of soup");
	}

	@Override
	public void onDoAddSpiceRaised() {
		// TODO Auto-generated method stub
		theMachine.messagesToUser2.setText("<html>add spices<br>according to the desired dose");
	}

	@Override
	public void onDoWaitHeatToHotRaised() {
		// TODO Auto-generated method stub
//		theMachine.messagesToUser.setText("<html>waiting for<br>the “hot” temperature");
	}

	@Override
	public void onDoLockDoorRaised() {
		// TODO Auto-generated method stub
//		theMachine.messagesToUser.setText("<html>manual door<br>locking in closed position");
	}



	@Override
	public void onDoOpenDoorRaised() {
		// TODO Auto-generated method stub
//		theMachine.messagesToUser.setText("<html>manual door<br>locking in copen position");
	}

	

	@Override
	public void onDoCleanRaised() {
		// TODO Auto-generated method stub
//		theMachine.messagesToUser.setText("<html>the internal<br>mechanism of the machine is cleaning");
		theMachine.messagesToUser.setText("Preparing");
		theMachine.messagesToUser1.setText("");
		theMachine.controlProgressBar(500, 10);
		
	}

	@Override
	public void onDoAddCoinRaised() {
		// TODO Auto-generated method stub
		theMachine.messagesToUser.setText("<html>Dear Sir/Lady<br>your have paid "+theMachine.curpay);
	}

	@Override
	public void onDoJudgeRBRaised() {
		// TODO Auto-generated method stub
		
		if(theMachine.curpay > 0) {
			theMachine.theFSM.raiseReturnCoins();
		}else if(isBiip) {
			theMachine.theFSM.raiseCancleTransaction();
		}
	}


	@Override
	public void onDoCancleTransactionRaised() {
		// TODO Auto-generated method stub
		theMachine.messagesToUser.setText("<html>canceled bank transaction");
	}

	@Override
	public void onDoJudgeIfReturnCoinsRaised() {
		// TODO Auto-generated method stub
		if(theMachine.curpay > theMachine.curprice) {
			theMachine.theFSM.raiseReturnCoins();
		}else {
			theMachine.theFSM.raiseReset();
		}
		
	}

	@Override
	public void onDoCancleOrderRaised() {
		// TODO Auto-generated method stub
		theMachine.messagesToUser.setText("<html>Order is cancelled");
	}

	@Override
	public void onDoNfcCaculateRaised() {
		// TODO Auto-generated method stub
		if(theMachine.curprice > 0) {
			theMachine.nfcPri+=1;
			theMachine.theFSM.raisePrepare();
		}
		
	}

	@Override
	public void onDoInjectSN2Raised() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onDoInjectLN2Raised() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void onDoChangeSliderRaised() {
		// TODO Auto-generated method stub
		theMachine.getContentPane().remove(theMachine.lblSpice);
		theMachine.getContentPane().remove(theMachine.spiceSlider);
		theMachine.getContentPane().repaint();
		theMachine.getContentPane().add(theMachine.lblSugar);
		theMachine.getContentPane().add(theMachine.sugarSlider);
		
		
	}

	@Override
	public void onDoChangeSliderToSoupRaised() {
		// TODO Auto-generated method stub
		theMachine.getContentPane().remove(theMachine.lblSugar);
		theMachine.getContentPane().remove(theMachine.sugarSlider);
		theMachine.getContentPane().repaint();//页面改变需要重新绘制
		theMachine.getContentPane().add(theMachine.lblSpice);
		theMachine.getContentPane().add(theMachine.spiceSlider);
			
	}

	@Override
	public void onDoChangeSliderToIcedTeaRaised() {
		// TODO Auto-generated method stub
//		if(theMachine.getContentPane().contains(theMachine.lblSpice))
		theMachine.getContentPane().remove(theMachine.lblTemperature);
		theMachine.getContentPane().remove(theMachine.temperatureSlider);
		theMachine.getContentPane().repaint();
		theMachine.getContentPane().add(theMachine.lblTime);
		theMachine.getContentPane().add(theMachine.timeSlider);
		
		
	}
	
	@Override
	public void onDoChangeSlider1Raised() {
		// TODO Auto-generated method stub
		theMachine.getContentPane().remove(theMachine.lblTime);
		theMachine.getContentPane().remove(theMachine.timeSlider);
		theMachine.getContentPane().repaint();
		theMachine.getContentPane().add(theMachine.lblTemperature);
		theMachine.getContentPane().add(theMachine.temperatureSlider);
		
	}

	@Override
	public void onDoChangeSliderToSoup1Raised() {
		// TODO Auto-generated method stub
		theMachine.getContentPane().remove(theMachine.lblSugar);
		theMachine.getContentPane().remove(theMachine.sugarSlider);
		theMachine.getContentPane().remove(theMachine.lblTime);
		theMachine.getContentPane().remove(theMachine.timeSlider);
		theMachine.getContentPane().repaint();
		theMachine.getContentPane().add(theMachine.lblSpice);
		theMachine.getContentPane().add(theMachine.spiceSlider);
		theMachine.getContentPane().add(theMachine.lblTemperature);
		theMachine.getContentPane().add(theMachine.temperatureSlider);
		
	}

	@Override
	public void onDoChangeSliderToIcedTea1Raised() {
		// TODO Auto-generated method stub
		theMachine.getContentPane().remove(theMachine.lblSpice);
		theMachine.getContentPane().remove(theMachine.spiceSlider);
		theMachine.getContentPane().remove(theMachine.lblTemperature);
		theMachine.getContentPane().remove(theMachine.temperatureSlider);
		theMachine.getContentPane().repaint();
		theMachine.getContentPane().add(theMachine.lblSugar);
		theMachine.getContentPane().add(theMachine.sugarSlider);
		theMachine.getContentPane().add(theMachine.lblTime);
		theMachine.getContentPane().add(theMachine.timeSlider);
		
	}

	@Override
	public void onDoJudgeN2TimeRaised() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void onDoDeleteInfoRaised() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onDoIfAddMilkRaised() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onDoAddMilkRaised() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onDoIfAddCroutonsRaised() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onDoAddCroutonsRaised() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onDoIfAddSiropRaised() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onDoAddSiropRaised() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onDoIfAddIceCreamRaised() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onDoAddIceCreamRaised() {
		// TODO Auto-generated method stub
		
	}
}



	


public class DrinkFactoryMachine extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2030629304432075314L;
	private JPanel contentPane;
	protected JLabel messagesToUser, messagesToUser1,messagesToUser2,lblCoins, lblSugar, lblSize, lblSpice,lblTime,lblNfc, 
	labelForPictures, lblTemperature, timeValue;
	protected JSlider sugarSlider, sizeSlider, temperatureSlider,spiceSlider,timeSlider;
	protected JButton coffeeButton, expressoButton, teaButton, soupButton, icedTeaButton, money50centsButton,
						money25centsButton, money10centsButton, nfcBiiiipButton, addCupButton, cancelButton,yesButton,noButton;
	protected String drinkType = "",coinType ="",nfcInfo="";
	protected int currentProgress=0, nfcPri = 0;//secs=45;
	protected JProgressBar progressBar;
	protected double curpay = 0.0,curprice = 0.0;
	protected Timer timer1,myTimer;
	protected boolean isOwnCup=false;
	protected boolean spiceExist=false,timeExist=false;
	private HashMap<String,Double> prices = new HashMap<String,Double>();
	protected DrinkFactoryMachineStatemachine theFSM;
	
	/**
	 * @wbp.nonvisual location=311,47
	 */
	private final ImageIcon imageIcon = new ImageIcon();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args)  {
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
	
	public void controlProgressBar(int delay, int endPosition) {
		ActionListener every10=new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            if(currentProgress<endPosition)
	                currentProgress+=1;
	            progressBar.setValue(currentProgress);
	        }
	    };
	    timer1=new Timer(delay,every10);
	    timer1.start();
	}
	
	public void controlRuningTime(int Position, String buttonType) {
		ActionListener every10=new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            if(currentProgress==Position) {
	            	switch(buttonType) {
	        		case "Coffee":
	        			theFSM.raisePr_coffee();
	        			break;
	        		case "Expresso":
	        			theFSM.raisePr_expresso();
	        			break;
	        		case "Iced Tea":
	        			theFSM.raisePr_icedTea();;
	        			break;
	        		case "Soup":
	        			theFSM.raisePr_soup();
	        			break;
	        		case "Tea":
	        			theFSM.raisePr_tea();
	        			break;
	        		case "Next":
	        			theFSM.raiseNextStep();
	        			break;
	        		default:
	        			break;
	            	}
	            }
	        }
	    };
	    myTimer=new Timer(10,every10);
	    myTimer.start();
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
		
		prices.put("Coffee", 0.35);
		prices.put("Tea", 0.4);
		prices.put("Expresso", 0.5);
		prices.put("Soup", 0.75);
		prices.put("Iced Tea", 0.5);//0.5 normal,0.75 long
		
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
		messagesToUser.setBounds(200, 50, 250, 80);
		contentPane.add(messagesToUser);
		

		messagesToUser1 = new JLabel("");
		messagesToUser1.setFont(new Font("Arial",Font.BOLD,20));
		messagesToUser1.setForeground(Color.white);
		messagesToUser1.setHorizontalAlignment(SwingConstants.LEFT);
		messagesToUser1.setVerticalAlignment(SwingConstants.TOP);
		messagesToUser1.setToolTipText("message to the user");
		messagesToUser1.setBackground(Color.white);
		messagesToUser1.setBounds(200, 150, 250, 80);
		contentPane.add(messagesToUser1);
		
		
		
		messagesToUser2 = new JLabel("");
		messagesToUser2.setFont(new Font("Arial",Font.BOLD,20));
		messagesToUser2.setForeground(Color.white);
		messagesToUser2.setHorizontalAlignment(SwingConstants.LEFT);
		messagesToUser2.setVerticalAlignment(SwingConstants.TOP);
		messagesToUser2.setToolTipText("message to the user");
		messagesToUser2.setBackground(Color.white);
		messagesToUser2.setBounds(200, 250, 250, 80);
		contentPane.add(messagesToUser1);

//		timeValue = new JLabel("");
//		timeValue.setFont(new Font("Arial",Font.BOLD,20));
//		timeValue.setForeground(Color.white);
//		timeValue.setHorizontalAlignment(SwingConstants.LEFT);
//		timeValue.setVerticalAlignment(SwingConstants.TOP);
//		timeValue.setBackground(Color.white);
//		timeValue.setBounds(200, 270, 250, 100);
//		contentPane.add(timeValue);
		
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
				theFSM.raiseAny_btn();
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
				theFSM.raiseAny_btn();
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
				theFSM.raiseAny_btn();
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
				theFSM.raiseAny_btn();
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
				theFSM.raiseType3_btn();
				theFSM.raiseAny_btn();
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
		sugarSlider.setValue(0);
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
		    	  theFSM.raiseAny_btn();
		      }
		});
		
		spiceSlider = new JSlider();
		spiceSlider.setValue(0);
		spiceSlider.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		spiceSlider.setBackground(Color.DARK_GRAY);
		spiceSlider.setForeground(Color.white);
		spiceSlider.setPaintTicks(true);
		spiceSlider.setMinorTickSpacing(1);
		spiceSlider.setMajorTickSpacing(1);
		spiceSlider.setMaximum(4);
		spiceSlider.setBounds(480, 80, 320, 55);
//		contentPane.add(spiceSlider);
		spiceSlider.addChangeListener(new ChangeListener() {
		      public void stateChanged(ChangeEvent event) {
		    	  theFSM.raiseSli1_btn();
		    	  theFSM.raiseAny_btn();
		      }
		});
		
		
		
		

		sizeSlider = new JSlider();
		sizeSlider.setPaintTicks(true);
		sizeSlider.setValue(0);
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
		    	  theFSM.raiseAny_btn();
		      }
		});

		temperatureSlider = new JSlider();
		temperatureSlider.setPaintLabels(true);
		temperatureSlider.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		temperatureSlider.setValue(0);
		temperatureSlider.setBackground(Color.DARK_GRAY);
		temperatureSlider.setForeground(Color.white);
		temperatureSlider.setPaintTicks(true);
		temperatureSlider.setMajorTickSpacing(1);
		temperatureSlider.setMaximum(3);
		temperatureSlider.setBounds(480, 340, 320, 85);
		temperatureSlider.addChangeListener(new ChangeListener() {
		      public void stateChanged(ChangeEvent event) {
		    	  theFSM.raiseSli3_btn();
		    	  theFSM.raiseAny_btn();
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

		
		timeSlider = new JSlider();
		timeSlider.setPaintLabels(true);
		timeSlider.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		timeSlider.setValue(0);
		timeSlider.setBackground(Color.DARK_GRAY);
		timeSlider.setForeground(Color.white);
		timeSlider.setPaintTicks(true);
		timeSlider.setMajorTickSpacing(1);
		timeSlider.setMaximum(1);
		timeSlider.setBounds(480, 340, 320, 85);
		timeSlider.addChangeListener(new ChangeListener() {
		      public void stateChanged(ChangeEvent event) {
		    	  theFSM.raiseSli3_btn();
		    	  theFSM.raiseAny_btn();
		      }
		});

		Hashtable<Integer, JLabel> temperatureTable1 = new Hashtable<Integer, JLabel>();
		temperatureTable1.put(0, new JLabel("normal"));
		temperatureTable1.put(1, new JLabel("long"));
		for (JLabel l : temperatureTable1.values()) {
			l.setForeground(Color.white);
		}
		timeSlider.setLabelTable(temperatureTable1);
		

		lblSugar = new JLabel("Sugar");
		lblSugar.setFont(new Font("Arial",Font.BOLD,20));
		lblSugar.setForeground(Color.white);
		lblSugar.setBackground(Color.white);
		lblSugar.setHorizontalAlignment(SwingConstants.CENTER);
		lblSugar.setBounds(620, 50, 65, 25);
		contentPane.add(lblSugar);
		
		lblSpice = new JLabel("Spice");
		lblSpice.setFont(new Font("Arial",Font.BOLD,20));
		lblSpice.setForeground(Color.white);
		lblSpice.setBackground(Color.white);
		lblSpice.setHorizontalAlignment(SwingConstants.CENTER);
		lblSpice.setBounds(620, 50, 65, 25);
//		contentPane.add(lblSugar);
		

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
		
		lblTime = new JLabel("Refrigerating Time");
		lblTime.setFont(new Font("Arial",Font.BOLD,20));
		lblTime.setForeground(Color.white);
		lblTime.setBackground(Color.white);
		lblTime.setHorizontalAlignment(SwingConstants.CENTER);
		lblTime.setBounds(555, 310, 180, 25);
		
		
		

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
				curpay+=0.5;
				BigDecimal b = new BigDecimal(curpay);
				curpay = b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
				theFSM.raisePay_coins();
				theFSM.raiseAny_btn();
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
				curpay+=0.25;
				BigDecimal b = new BigDecimal(curpay);
				curpay = b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
				theFSM.raisePay_coins();
				theFSM.raiseAny_btn();
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
				curpay+=0.1;
				BigDecimal b = new BigDecimal(curpay);
				curpay = b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
				theFSM.raisePay_coins();
				theFSM.raiseAny_btn();
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
				theFSM.raiseNfc_btn();
				theFSM.raiseAny_btn();
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
		addCupButton.setBounds(100, 550, 150, 40);
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
		theFSM.raiseAddCup_Btn();
			
		
		yesButton = new JButton("Yes");
		yesButton.setFont(new Font("Arial",Font.BOLD,20));
		yesButton.setForeground(Color.DARK_GRAY);
		yesButton.setBackground(Color.white);
		yesButton.setBounds(100, 650, 150, 40);
		contentPane.add(yesButton);
		yesButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				theFSM.raiseY();
				theFSM.raiseAny_btn();
			}
		});

		
		noButton = new JButton("No");
		noButton.setFont(new Font("Arial",Font.BOLD,20));
		noButton.setForeground(Color.DARK_GRAY);
		noButton.setBackground(Color.white);
		noButton.setBounds(100, 750, 150, 40);
		contentPane.add(noButton);
		noButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				theFSM.raiseN();
				theFSM.raiseAny_btn();
			}
		});
	}
}
