package org.openjump.core.ui.plot;

import java.awt.*;

import javax.swing.*;

import org.math.plot.*;
import org.math.plot.render.*;
import org.math.plot.utils.*;

import com.vividsolutions.jump.workbench.model.Layer;
import com.vividsolutions.jump.workbench.plugin.PlugInContext;

public class BarPlotOJ extends ScatterPlotOJ{

	public boolean draw_dot = true;

	public BarPlotOJ(String n, Color c, double[][] _XY, int[] featureID, PlugInContext context, Layer layer) {
		super(n, c, _XY, featureID, context, layer);
	}

	public void plot(AbstractDrawer draw, Color c) {
		if (!visible)
			return;

		if (draw_dot)
			super.plot(draw, c);

		draw.setColor(c);
		draw.setLineType(AbstractDrawer.CONTINOUS_LINE);
		for (int i = 0; i < XY.length; i++) {
			double[] axeprojection = Array.copy(XY[i]);
			axeprojection[axeprojection.length - 1] = draw.canvas.base.baseCoords[0][axeprojection.length - 1];
			draw.drawLine(XY[i], axeprojection);
		}
	}

	public static void main(String[] args) {
		Plot2DPanel p2 = new Plot2DPanel();
		for (int i = 0; i < 3; i++) {
			double[][] XYZ = new double[10][2];
			for (int j = 0; j < XYZ.length; j++) {
				XYZ[j][0] = /*1 + */Math.random();
				XYZ[j][1] = /*100 * */Math.random();
			}
			p2.addBarPlot("toto" + i, XYZ);
		}

		p2.setLegendOrientation(PlotPanel.SOUTH);
		new FrameView(p2).setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Plot3DPanel p = new Plot3DPanel();
		for (int i = 0; i < 3; i++) {
			double[][] XYZ = new double[10][3];
			for (int j = 0; j < XYZ.length; j++) {
				XYZ[j][0] = /*1 +*/Math.random();
				XYZ[j][1] = /*100 **/Math.random();
				XYZ[j][2] = /*0.0001 **/Math.random();
			}
			p.addBarPlot("toto" + i, XYZ);
		}

		p.setLegendOrientation(PlotPanel.SOUTH);
		new FrameView(p).setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}