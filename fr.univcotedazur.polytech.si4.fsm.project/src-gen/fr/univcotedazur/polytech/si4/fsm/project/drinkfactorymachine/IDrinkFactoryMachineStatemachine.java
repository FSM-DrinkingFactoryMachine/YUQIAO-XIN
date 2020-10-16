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
	
		public void raiseSelect_Type_Btn();
		
		public void raisePay_coins_Btn();
		
		public void raiseNFC_Btn();
		
		public void raiseCancle_Btn();
		
		public void raiseAddCup_Btn();
		
		public void raiseModify_Slider();
		
		public boolean isRaisedDoReset();
		
		public boolean isRaisedDoPrepare();
		
		public boolean isRaisedDoModify();
		
		public boolean isRaisedDoCaculate();
		
	public List<SCInterfaceListener> getListeners();
	}
	
	public interface SCInterfaceListener {
	
		public void onDoResetRaised();
		public void onDoPrepareRaised();
		public void onDoModifyRaised();
		public void onDoCaculateRaised();
		}
	
	public SCInterface getSCInterface();
	
}
