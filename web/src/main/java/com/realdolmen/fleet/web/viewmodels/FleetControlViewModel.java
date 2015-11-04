package com.realdolmen.fleet.web.viewmodels;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by SDOAX36 on 3/11/2015.
 */
public class FleetControlViewModel {

    private int totalAudi;
    private int totalSkoda;
    private int totalVolkswagen;
    private int totalSeat;
    private int total;

    private FleetControlViewModelPercentage percentage;


    public FleetControlViewModel(int totalAudi, int totalSkoda, int totalVolkswagen, int totalSeat) {
        this.totalAudi = totalAudi;
        this.totalVolkswagen = totalVolkswagen;
        this.totalSkoda = totalSkoda;
        this.totalSeat = totalSeat;
        this.total = totalAudi + totalSeat + totalSkoda + totalVolkswagen;
        this.percentage = new FleetControlViewModelPercentage(totalAudi,totalSeat,totalSkoda,totalVolkswagen,total);

    }


    public FleetControlViewModelPercentage getPercentage() {
        return percentage;
    }

    public void setPercentage(FleetControlViewModelPercentage percentage) {
        this.percentage = percentage;
    }

    public int getTotalAudi() {
        return totalAudi;
    }

    public void setTotalAudi(int totalAudi) {
        this.totalAudi = totalAudi;
    }

    public int getTotalSkoda() {
        return totalSkoda;
    }

    public void setTotalSkoda(int totalSkoda) {
        this.totalSkoda = totalSkoda;
    }

    public int getTotalVolkswagen() {
        return totalVolkswagen;
    }

    public void setTotalVolkswagen(int totalVolkswagen) {
        this.totalVolkswagen = totalVolkswagen;
    }

    public int getTotalSeat() {
        return totalSeat;
    }

    public void setTotalSeat(int totalSeat) {
        this.totalSeat = totalSeat;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public Map<String,Integer> toHashMap()
    {
        Map<String,Integer>result = new HashMap<>();
        result.put("Audi",this.totalAudi);
        result.put("Skoda",this.totalSkoda);
        result.put("Volkswagen",this.totalVolkswagen);
        result.put("Seat",this.totalSeat);
        return result;
    }



    public class FleetControlViewModelPercentage {

        private String totalAudi;
        private String totalSkoda;
        private String totalVolkswagen;
        private String totalSeat;


        public FleetControlViewModelPercentage(int totalAudi, int totalSeat, int totalSkoda, int totalVolkswagen, int total) {
            this.totalAudi = calcPercetage(totalAudi,total);
            this.totalSeat = calcPercetage(totalSeat,total);
            this.totalVolkswagen = calcPercetage(totalVolkswagen,total);
            this.totalSkoda = calcPercetage(totalSkoda,total);
        }

        private String calcPercetage(int aantal, int total) {
            if(total != 0)
            {
                float result = (aantal*100.0f)/total;
                System.out.println("CalcPercentage = "+result);
                return String.format("%.2f", result)+"%";
            }

            return "Value not known";

        }

        public String getTotalAudi() {
            return totalAudi;
        }

        public void setTotalAudi(String totalAudi) {
            this.totalAudi = totalAudi;
        }

        public String getTotalSkoda() {
            return totalSkoda;
        }

        public void setTotalSkoda(String totalSkoda) {
            this.totalSkoda = totalSkoda;
        }

        public String getTotalVolkswagen() {
            return totalVolkswagen;
        }

        public void setTotalVolkswagen(String totalVolkswagen) {
            this.totalVolkswagen = totalVolkswagen;
        }

        public String getTotalSeat() {
            return totalSeat;
        }

        public void setTotalSeat(String totalSeat) {
            this.totalSeat = totalSeat;
        }
    }
}
