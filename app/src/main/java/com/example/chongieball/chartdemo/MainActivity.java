package com.example.chongieball.chartdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.github.mikephil.charting.listener.OnChartGestureListener;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;

import java.util.ArrayList;
import java.util.List;

import lecho.lib.hellocharts.model.Axis;
import lecho.lib.hellocharts.model.AxisValue;
import lecho.lib.hellocharts.model.Line;
import lecho.lib.hellocharts.model.LineChartData;
import lecho.lib.hellocharts.model.PointValue;
import lecho.lib.hellocharts.model.ValueShape;
import lecho.lib.hellocharts.model.Viewport;
import lecho.lib.hellocharts.view.LineChartView;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();

    private LineChartView mChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Model> modelA = new ArrayList<>();
        modelA.add(new Model(0, "0"));
        modelA.add(new Model(1, "1"));
        modelA.add(new Model(2, "3"));
        modelA.add(new Model(3, "4"));
        modelA.add(new Model(4, "1"));
        modelA.add(new Model(5, "2"));
        modelA.add(new Model(6, "3"));
        modelA.add(new Model(7, "3"));
        modelA.add(new Model(8, "3"));

        List<Model> modelB = new ArrayList<>();
        modelB.add(new Model(0, "2"));
        modelB.add(new Model(1, "2"));
        modelB.add(new Model(2, "4"));
        modelB.add(new Model(3, "3"));
        modelB.add(new Model(4, "2"));
        modelB.add(new Model(5, "1"));
        modelB.add(new Model(6, "1"));
        modelB.add(new Model(7, "1"));
        modelB.add(new Model(8, "1"));

        mChart = (LineChartView) findViewById(R.id.lc_main);

        Viewport viewport = new Viewport(mChart.getMaximumViewport());
        viewport.bottom = 0;
        viewport.left = 0;
        viewport.top = 5;
        viewport.right = 7;

        mChart.setViewportCalculationEnabled(false);

        mChart.setMaximumViewport(viewport);
        mChart.setCurrentViewport(viewport);

        List<Line> lines = new ArrayList<>();
        List<PointValue> valuesA = new ArrayList<>();
        List<PointValue> valuesB = new ArrayList<>();

        for (Model model : modelA) {
            valuesA.add(new PointValue(model.getX(), Integer.parseInt(model
                    .getY())));
        }

        for (Model model : modelB) {
            valuesB.add(new PointValue(model.getX(), Integer.parseInt(model
                    .getY())));
        }


        Line lineA = new Line(valuesA);
        lineA.setHasLines(true);
        lineA.setColor(R.color.colorPrimaryDark);
        lineA.setShape(ValueShape.CIRCLE);
        lineA.setHasPoints(true);
        lineA.setCubic(true);

        Line lineB = new Line(valuesB);
        lineB.setHasLines(true);
        lineB.setColor(R.color.colorPrimary);
        lineB.setShape(ValueShape.CIRCLE);
        lineB.setHasPoints(true);
        lineB.setCubic(true);


        lines.add(lineA);
        lines.add(lineB);

        LineChartData data = new LineChartData(lines);

//        Axis.generateAxisFromRange()
        Axis x = new Axis(Axis.generateAxisFromRange(0, 5, 1));
        Log.d(TAG, "" + x.getMaxLabelChars());
        Axis y = new Axis();

        String labelY[] = {"Satu", "Dua", "Tiga", "Empat"};
        List<AxisValue> yValue = new ArrayList<>();

        for (int i = 1; i < labelY.length; i++) {
            yValue.add(new AxisValue(i, labelY[i].toCharArray()));
        }
        Log.d(TAG, "" + y.getMaxLabelChars());
        data.setAxisXBottom(x);
        data.setAxisYLeft(y);
        y.setValues(yValue);

        mChart.setZoomEnabled(false);
        mChart.setLineChartData(data);
    }
}
