/** Generated by YAKINDU Statechart Tools code generator. */
package fr.univcotedazur.polytech.si4.fsm.project.drinkfactorymachine;

import fr.univcotedazur.polytech.si4.fsm.project.IStatemachine;
import fr.univcotedazur.polytech.si4.fsm.project.ITimerCallback;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public interface IDrinkFactoryMachineStatemachine extends ITimerCallback,IStatemachine {
	public interface SCInterface {
	
		public void raiseType1_btn();
		
		public void raiseType2_btn();
		
		public void raiseType3_btn();
		
		public void raiseSli1_btn();
		
		public void raiseSli2_btn();
		
		public void raiseSli3_btn();
		
		public void raisePay_coins();
		
		public void raiseNfc_btn();
		
		public void raiseCancle_btn();
		
		public void raiseAddCup_Btn();
		
		public void raisePr_icedTea();
		
		public void raisePr_tea();
		
		public void raisePr_soup();
		
		public void raisePr_coffee();
		
		public void raisePr_expresso();
		
		public void raiseAny_btn();
		
		public void raiseNeedCup();
		
		public void raiseShort();
		
		public void raiseLong();
		
		public void raisePrepare();
		
		public void raiseReset();
		
		public void raiseNextStep();
		
		public void raiseReturnCoins();
		
		public void raiseCancleTransaction();
		
		public void raiseY();
		
		public void raiseN();
		
		public void raiseEnough();
		
		public boolean isRaisedDoReset();
		
		public boolean isRaisedDoCaculate();
		
		public boolean isRaisedDoChangeType();
		
		public boolean isRaisedDoModify1();
		
		public boolean isRaisedDoModify2();
		
		public boolean isRaisedDoModify3();
		
		public boolean isRaisedDoStoreInfo();
		
		public boolean isRaisedDoChangePrice();
		
		public boolean isRaisedDoRefund();
		
		public boolean isRaisedDoResetTime();
		
		public boolean isRaisedDoInitialNfcInfo();
		
		public boolean isRaisedDoNfcCaculate();
		
		public boolean isRaisedDoJudgeType();
		
		public boolean isRaisedDoSetDosette();
		
		public boolean isRaisedDoHeatWater();
		
		public boolean isRaisedDoWaitHeat();
		
		public boolean isRaisedDoPutCup();
		
		public boolean isRaisedDoAddSugar();
		
		public boolean isRaisedDoAddWater();
		
		public boolean isRaisedDoAddWater1();
		
		public boolean isRaisedDoCrushGrain();
		
		public boolean isRaisedDoTampGrain();
		
		public boolean isRaisedDoSetSachet();
		
		public boolean isRaisedDoWaitInfusion();
		
		public boolean isRaisedDoWithdrawSachet();
		
		public boolean isRaisedDoJudgeCup();
		
		public boolean isRaisedDoSetSoup();
		
		public boolean isRaisedDoAddSpice();
		
		public boolean isRaisedDoWaitHeatToHot();
		
		public boolean isRaisedDoLockDoor();
		
		public boolean isRaisedDoInjectSN2();
		
		public boolean isRaisedDoInjectLN2();
		
		public boolean isRaisedDoOpenDoor();
		
		public boolean isRaisedDoWaitTake();
		
		public boolean isRaisedDoJudgeN2Time();
		
		public boolean isRaisedDoClean();
		
		public boolean isRaisedDoAddCoin();
		
		public boolean isRaisedDoJudgeRB();
		
		public boolean isRaisedDoJudgeIfReturnCoins();
		
		public boolean isRaisedDoCancleTransaction();
		
		public boolean isRaisedDoCancleOrder();
		
		public boolean isRaisedDoChangeSlider();
		
		public boolean isRaisedDoChangeSliderToSoup();
		
		public boolean isRaisedDoChangeSliderToIcedTea();
		
		public boolean isRaisedDoChangeSlider1();
		
		public boolean isRaisedDoChangeSliderToSoup1();
		
		public boolean isRaisedDoChangeSliderToIcedTea1();
		
		public boolean isRaisedDoDeleteInfo();
		
		public boolean isRaisedDoIfAddMilk();
		
		public boolean isRaisedDoAddMilk();
		
		public boolean isRaisedDoIfAddCroutons();
		
		public boolean isRaisedDoAddCroutons();
		
		public boolean isRaisedDoIfAddSirop();
		
		public boolean isRaisedDoAddSirop();
		
		public boolean isRaisedDoIfAddIceCream();
		
		public boolean isRaisedDoAddIceCream();
		
		public boolean isRaisedDoIfEnoughMoney1();
		
		public boolean isRaisedDoIfEnoughMoney2();
		
		public boolean isRaisedDoIfEnoughMoney3();
		
		public boolean isRaisedDoIfEnoughMoney4();
		
		public boolean isRaisedDoAddCup();
		
	public List<SCInterfaceListener> getListeners();
	}
	
	public interface SCInterfaceListener {
	
		public void onDoResetRaised();
		public void onDoCaculateRaised();
		public void onDoChangeTypeRaised();
		public void onDoModify1Raised();
		public void onDoModify2Raised();
		public void onDoModify3Raised();
		public void onDoStoreInfoRaised();
		public void onDoChangePriceRaised();
		public void onDoRefundRaised();
		public void onDoResetTimeRaised();
		public void onDoInitialNfcInfoRaised();
		public void onDoNfcCaculateRaised();
		public void onDoJudgeTypeRaised();
		public void onDoSetDosetteRaised();
		public void onDoHeatWaterRaised();
		public void onDoWaitHeatRaised();
		public void onDoPutCupRaised();
		public void onDoAddSugarRaised();
		public void onDoAddWaterRaised();
		public void onDoAddWater1Raised();
		public void onDoCrushGrainRaised();
		public void onDoTampGrainRaised();
		public void onDoSetSachetRaised();
		public void onDoWaitInfusionRaised();
		public void onDoWithdrawSachetRaised();
		public void onDoJudgeCupRaised();
		public void onDoSetSoupRaised();
		public void onDoAddSpiceRaised();
		public void onDoWaitHeatToHotRaised();
		public void onDoLockDoorRaised();
		public void onDoInjectSN2Raised();
		public void onDoInjectLN2Raised();
		public void onDoOpenDoorRaised();
		public void onDoWaitTakeRaised();
		public void onDoJudgeN2TimeRaised();
		public void onDoCleanRaised();
		public void onDoAddCoinRaised();
		public void onDoJudgeRBRaised();
		public void onDoJudgeIfReturnCoinsRaised();
		public void onDoCancleTransactionRaised();
		public void onDoCancleOrderRaised();
		public void onDoChangeSliderRaised();
		public void onDoChangeSliderToSoupRaised();
		public void onDoChangeSliderToIcedTeaRaised();
		public void onDoChangeSlider1Raised();
		public void onDoChangeSliderToSoup1Raised();
		public void onDoChangeSliderToIcedTea1Raised();
		public void onDoDeleteInfoRaised();
		public void onDoIfAddMilkRaised();
		public void onDoAddMilkRaised();
		public void onDoIfAddCroutonsRaised();
		public void onDoAddCroutonsRaised();
		public void onDoIfAddSiropRaised();
		public void onDoAddSiropRaised();
		public void onDoIfAddIceCreamRaised();
		public void onDoAddIceCreamRaised();
		public void onDoIfEnoughMoney1Raised();
		public void onDoIfEnoughMoney2Raised();
		public void onDoIfEnoughMoney3Raised();
		public void onDoIfEnoughMoney4Raised();
		public void onDoAddCupRaised();
		}
	
	public SCInterface getSCInterface();
	
}
