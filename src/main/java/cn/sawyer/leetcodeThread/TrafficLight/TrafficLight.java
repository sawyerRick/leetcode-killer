package cn.sawyer.leetcodeThread.TrafficLight;

/**
 * @program: LeetCode
 * @description: 红绿灯路口，https://leetcode-cn.com/problems/traffic-light-controlled-intersection/
 * @author: sawyer
 * @create: 2020-02-19 22:20
 **/
public class TrafficLight {

    public TrafficLight() {

    }

    public void carArrived(
            int carId,           // ID of the car
            int roadId,          // ID of the road the car travels on. Can be 1 (road A) or 2 (road B)
            int direction,       // Direction of the car
            Runnable turnGreen,  // Use turnGreen.run() to turn light to green on current road
            Runnable crossCar    // Use crossCar.run() to make car cross the intersection
    ) {

    }
}