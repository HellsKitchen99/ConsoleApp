package com.test;

import com.google.gson.annotations.SerializedName;

public class IBP {
    @SerializedName("ups_adv_output_load")
    public Integer OutputLoad;
     @SerializedName("ups_adv_battery_temperature")
    public Integer BatteryTemperature;
     @SerializedName("timestamp")
    public String Timestamp;
     @SerializedName("host")
    public String Host;
     @SerializedName("ups_adv_battery_run_time_remaining")
    public Integer BatteryRuntimeRemaining;
     @SerializedName("ups_adv_output_voltage")
    public Integer OutputVoltage;
}
