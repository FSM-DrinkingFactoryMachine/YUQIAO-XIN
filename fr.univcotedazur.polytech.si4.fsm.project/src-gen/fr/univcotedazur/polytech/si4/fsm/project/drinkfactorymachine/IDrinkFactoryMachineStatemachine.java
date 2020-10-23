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
		
		public void raiseSli1_btn();
		
		public void raiseSli2_btn();
		
		public void raiseSli3_btn();
		
		public void raisePay_coins();
		
		public void raiseNfc_btn();
		
		public void raiseCancle_btn();
		
		public void raiseAddCup_Btn();
		
		public boolean isRaisedDoReset();
		
		public boolean isRaisedDoPrepare();
		
		public boolean isRaisedDoCaculate();
		
		public boolean isRaisedDoChangeType();
		
		public boolean isRaisedDoModify1();
		
		public boolean isRaisedDoModify2();
		
		public boolean isRaisedDoModify3();
		
		public boolean isRaisedDoStoreInfo();
		
		public boolean isRaisedDoChangePrice();
		
		public boolean isRaisedDoRefund();
		
		public boolean isRaisedDoShowPricePay();
		
	public List<SCInterfaceListener> getListeners();
	}
	
	public interface SCInterfaceListener {
	
		public void onDoResetRaised();
		public void onDoPrepareRaised();
		public void onDoCaculateRaised();
		public void onDoChangeTypeRaised();
		public void onDoModify1Raised();
		public void onDoModify2Raised();
		public void onDoModify3Raised();
		public void onDoStoreInfoRaised();
		public void onDoChangePriceRaised();
		public void onDoRefundRaised();
		public void onDoShowPricePayRaised();
		}
	
	public SCInterface getSCInterface();
	
}
