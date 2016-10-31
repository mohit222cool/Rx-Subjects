package rxsubject.variants;

import rx.Observable;
import rx.Subscriber;
import rx.subjects.BehaviorSubject;

import java.util.concurrent.TimeUnit;

/**
 * Created by mohit.sharma on 10/19/16.
 */
public class BehaviourSubjectDemo {
    public static void main(String[] args) {

        Observable<Long> cold = Observable.interval(1000, TimeUnit.MILLISECONDS);
        BehaviorSubject<Long> behaviorSubject = BehaviorSubject.create(-1L);
        behaviorSubject.subscribe(subscriber1);
        behaviorSubject.subscribe(subscriber2);
        cold.subscribe(behaviorSubject);
        addSomeDelay();
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
            System.out.println("Subscriber 1 : " + Long);
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
            System.out.println("Subscriber 2 : " + Long);
        }
    };
}
