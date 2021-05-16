package hu.bme.mit.train.tachograph;

import hu.bme.mit.train.interfaces.TrainSensor;
import hu.bme.mit.train.interfaces.TrainUser;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.Set;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;

import java.util.Calendar;

public class TrainTachograph {

    private TrainUser tu;
    private TrainSensor ts;
    private Table<LocalDateTime, Integer, Integer> tachoTable;

    public TrainTachograph(TrainUser _tu, TrainSensor _ts){
        tu= _tu; ts=_ts;
        tachoTable= HashBasedTable.create();
    }

    public void add(){
        tachoTable.put(LocalDateTime.now(), tu.getJoystickPosition(), ts.getSpeedLimit());
    }

}
