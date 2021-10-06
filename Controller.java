//Elizabeth Sims
//September 22, 2021
//Assignment 3

import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.io.PrintWriter;

class Controller implements ActionListener, MouseListener, KeyListener {
	final String JSON_FILE = "data.json";

	View view;
	Model model;
	boolean keyLeft;
	boolean keyRight;
	boolean keyUp;
	boolean keyDown;
	int clickX;
	int clickY;

	Controller(Model m) {
		model = m;
	}

	public void actionPerformed(ActionEvent e) 
	{
		view.removeButton();
	}

	void setView(View v) {
		view = v;
	}


	public void mousePressed(MouseEvent e) 
	{
		clickX = e.getX() + model.cameraPos;
		clickY = e.getY();
	}

	public void mouseReleased(MouseEvent e) 
	{
		Brick b = new Brick(Math.min(clickX, e.getX() + model.cameraPos), Math.min(clickY, e.getY()),
				Math.abs(clickX - (e.getX() + model.cameraPos)), Math.abs(clickY - e.getY()));
		model.bricks.add(b);
	}

	public void mouseEntered(MouseEvent e) {
	}

	public void mouseExited(MouseEvent e) {
	}

	public void mouseClicked(MouseEvent e) {
	}

	@Override
	public void keyTyped(KeyEvent e) 
	{

	}

	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {
			case KeyEvent.VK_RIGHT:
				keyRight = true;
				break;
			case KeyEvent.VK_LEFT:
				keyLeft = true;
				break;
			case KeyEvent.VK_UP:
				keyUp = true;
				break;
			case KeyEvent.VK_DOWN:
				keyDown = true;
				break;
		}
	}

	public void keyReleased(KeyEvent e) {
		switch (e.getKeyCode()) {
			case KeyEvent.VK_RIGHT:
				keyRight = false;
				break;
			case KeyEvent.VK_LEFT:
				keyLeft = false;
				break;
			case KeyEvent.VK_UP:
				keyUp = false;
				break;
			case KeyEvent.VK_DOWN:
				keyDown = false;
				break;
			case KeyEvent.VK_ESCAPE:
				System.out.println("Exiting now...");
				System.exit(0);
				break;
		}
		char c = e.getKeyChar();
		if (c == 's' || c == 'S') 
		{
		   model.marshal().save(JSON_FILE);
		}
		else if (c == 'l' || c == 'L') 
		{	
			model.load(Json.load(JSON_FILE));
		}
	}

	void update() {
		if (keyRight)
			model.cameraPos += 4;
		if (keyLeft)
			model.cameraPos -= 4;
	}
}
