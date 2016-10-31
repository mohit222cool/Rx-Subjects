package rxsubject.connectableobservable;

import rx.Observable;
import rx.Subscriber;
import rx.observables.ConnectableObservable;

import java.sql.Time;
import java.util.concurrent.TimeUnit;

/**
 * Created by mohit.sharma on 10/18/16.
 */
public class ReplayConnectable {

    public static void main(String[] args) {

        Observable<Long> coldObservable = Observable.create(subscriber -> {
            for (long i = 0; i <= 5; i++) {
                System.out.println("Source Emits : " + i);
                subscriber.onNext(i);
            }
        });

        ConnectableObservable<Long> connectableObservable = coldObservable.replay();
        connectableObservable.subscribe(subscriber1);
        connectableObservable.connect();
        connectableObservable.subscribe(subscriber2);

    }


    private static void addSomeDelay() {
        try {
            System.out.println("Wait for some seconds");
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static Subscriber<Long> subscriber1 = new Subscriber<Long>() {
        @Override
        public void onCompleted() {

        }

        @Override
        public void onError(Throwable throwable) {

        }

        @Override
        public void onNext(Long Long) {
            System.out.println("Subscriber 1 :" + Long);
        }
    };

    private static Subscriber<Long> subscriber2 = new Subscriber<Long>() {
        @Override
        public void onCompleted() {

        }

        @Override
        public void onError(Throwable throwable) {

        }

        @Override
        public void onNext(Long Long) {
            System.out.println("Subscriber 2 :" + Long);
        }
    };

    private static Subscriber<Long> subscriber3 = new Subscriber<Long>() {
        @Override
        public void onCompleted() {

        }

        @Override
        public void onError(Throwable throwable) {

        }

        @Override
        public void onNext(Long Long) {
            System.out.println("Subscriber 3 :" + Long);
        }
    };

}
