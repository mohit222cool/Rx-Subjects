package rxsubject.variants;

import rx.Observable;
import rx.Subscriber;
import rx.subjects.BehaviorSubject;

import java.util.concurrent.TimeUnit;

/**
 * Created by mohit.sharma on 10/19/16.
 */
public class BehaviourSubjectDemoWithDefaultValue {
    public static void main(String[] args) {

        Observable<Long> coldObservable = Observable.interval(1000, TimeUnit.MILLISECONDS);
        
        BehaviorSubject<Long> behaviorSubject = BehaviorSubject.create(-1L);
        coldObservable.subscribe(behaviorSubject);

        addSomeDelay();

        behaviorSubject.subscribe(subscriber1);
        behaviorSubject.subscribe(subscriber2);

        addSomeDelay();
 }

    private static void addSomeDelay() {
        try {
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
