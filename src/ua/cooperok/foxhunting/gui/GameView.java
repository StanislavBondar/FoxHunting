package ua.cooperok.foxhunting.gui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.content.res.TypedArray;
import android.view.View;
import android.view.View.MeasureSpec;

import ua.cooperok.foxhunting.R;
import ua.cooperok.foxhunting.game.CellCollection;

public class GameView extends View {
	
	private Paint mCellColor;
	
	protected CellCollection field;
	
	protected int paddingLeft = 50;
	protected int paddingRight = 50;
	protected int paddingTop = 50;
	protected int paddingBottom = 50;
	
	protected int cellWidth;
	protected int cellHeight;

	public GameView(Context context, AttributeSet attrs) {

		super(context);
		
		field = new CellCollection();
		
		mCellColor = new Paint();
		
		TypedArray a = context.getTheme().obtainStyledAttributes(
		        attrs,
		        R.styleable.GameView,
		        0, 0);

		   try {
			   
		       setColor(a.getColor(R.styleable.GameView_cellColor, Color.WHITE));
		       
		   } finally {
			   
		       a.recycle();
		       
		   }		

	}
	
	protected void setColor(int color) {
		
		mCellColor.setColor(color);
		
	}
	
	protected void onDraw(Canvas canvas) {
	
		super.onDraw(canvas);
		
		int cellLeft, cellTop;
		
		for(int row = 0; row < field.getWidth(); row++) {
			
			for(int col = 0; col < field.getHeight(); col++) {
				
				cellLeft = Math.round((col * cellWidth) + paddingLeft);
				cellTop = Math.round((row * cellHeight) + paddingTop);
				
				canvas.drawRect(cellLeft, cellTop, cellLeft + cellWidth -2, cellTop + cellHeight -2, mCellColor);
				
			}
			
		}
		
	}
	
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		
		int width = MeasureSpec.getSize(widthMeasureSpec);
		
		int height = MeasureSpec.getSize(heightMeasureSpec);
		
        cellWidth = (width - paddingLeft - paddingRight) / field.getWidth();
        
        cellHeight = (height - paddingTop - paddingBottom) / field.getHeight();
        
        setMeasuredDimension(width, height);
        
	}
	
	public int getCellWidth() {
		
		return cellWidth;
		
	}

}
