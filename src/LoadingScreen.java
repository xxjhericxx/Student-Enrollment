public class LoadingScreen implements Runnable{

	public void run() {
		
		Splash sp = new Splash();
		sp.setVisible(true);
		
		try {
			for (int i=0; i<=100; i++) {
				Thread.sleep(50);
				Splash.lblPercent.setText(""+i+"%");
				Splash.progressBar.setValue(i);
				
				if (i == 100) {
					WelcomeFrame wc = new WelcomeFrame();
					sp.setVisible(false);
					wc.main(null);
				}
			}
		}
		catch (InterruptedException e){
			e.printStackTrace();
		}
	}

}