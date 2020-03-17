package App;

public class calcClockAngle {

        public double calcClockAngle(String time) {

                String[] times = time.split(":");
                int min = Integer.parseInt(times[1]);
                double minAnlge = min * 360 / 60;
                int totalMin = Integer.parseInt(times[0]) * 60 + min;
                double hourAngle = totalMin * 360 / 60 / 12;

                double res = Math.abs(hourAngle - minAnlge);
                if(res > 180)
                    res = 360 - res;
                return res;
        }
}
