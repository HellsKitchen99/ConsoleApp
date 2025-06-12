package com.test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.google.gson.reflect.TypeToken;
import com.google.gson.Gson;
import com.google.gson.JsonIOException;

public class App {
    public static double Avg(int[] mass) {
        double total = 0;
        for (int i = 0; i < mass.length; i++) {
            total += mass[i];
        }
        double avg = total / mass.length;
        return avg;
    }

    public static int Max(int[] mass) {
        for (int i = 0; i < mass.length; i++) {
            for (int j = 0; j < mass.length - 1; j++) {
                if (mass[j] > mass[j + 1]) {
                    int temp = mass[j];
                    mass[j] = mass[j + 1];
                    mass[j + 1] = temp;
                }
            }
        }
        int max = mass[mass.length - 1];
        return max;
    }

    public static String[] Values(List < IBP > massIBP) {
        Map < String, Integer > map = new HashMap();
        int count = 0;
        for (int i = 0; i < massIBP.size(); i++) {
            IBP el = massIBP.get(i);
            if (el.Host != null && !map.containsKey(el.Host)) {
                map.put(el.Host, count++);
            } else {
                continue;
            }
        }
        String[] mass = new String[map.size()];
        int i = 0;
        for (String key: map.keySet()) {
            mass[i++] = key;
        }
        return mass;
    }
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.print("Неправильный ввод запуска программы через java -jar");
            return;
        }
        String function = args[0];
        String filename = args[1];
        
        FileReader reader = null;
        try {
            reader = new FileReader(filename);
        } catch (FileNotFoundException err) {
            System.out.print("ошибка чтения файла - " + err);
            return;
        }
        Type listIBPs = new TypeToken < List < IBP >> () {}.getType();
        List < IBP > massIBP;
        Gson gson = new Gson();
        try {
            massIBP = gson.fromJson(reader, listIBPs);
        } catch (JsonIOException err) {
            System.out.print("ошибка при парсинге данных - " + err);
            return;
        }
        switch (function.toLowerCase()) {
            case "avg":
                List < Integer > avgList = new ArrayList < > ();
                for (IBP ibp: massIBP) {
                    if (ibp.BatteryRuntimeRemaining != null) {
                        avgList.add(ibp.BatteryRuntimeRemaining);
                    } else {
                        continue;
                    }
                }
                int[] massForAvg = avgList.stream().mapToInt(i -> i).toArray();
                double averageBatteryRuntimeRemaining = Avg(massForAvg);
                System.out.print("Среднее значение оставшегося времени работы батареи - " + averageBatteryRuntimeRemaining + "\n");
                return;
            case "max":
                List < Integer > maxList = new ArrayList < > ();
                for (IBP ibp: massIBP) {
                    if (ibp.OutputVoltage != null) {
                        maxList.add(ibp.OutputVoltage);
                    } else {
                        continue;
                    }
                }
                int[] massForMax = maxList.stream().mapToInt(i -> i).toArray();
                int max = Max(massForMax);
                System.out.print("Максимальная выходная мощь - " + max + "\n");
                return;
            case "uniquevalues":
                String[] exclusiveValues = Values(massIBP);
                System.out.print("Эксклюзивные значения - ");
                for (String value: exclusiveValues) {
                    System.out.print(value + " ");
                }
                return;
        }
    }
}