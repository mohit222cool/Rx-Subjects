package rxsubject.variants;

import rx.Observable;
import rx.Subscriber;
import rx.subjects.ReplaySubject;

import java.util.concurrent.TimeUnit;

/**
 * Created by mohit.sharma on 10/19/16.
 */
public class ReplaySubjectDemo {
    public static void main(String[] args) {

        Observable<Long> coldObservable = Observable.interval(1000, TimeUnit.MILLISECONDS);
        
        ReplaySubject<Long> publishSubject = ReplaySubject.create();
        coldObservable.subscribe(publishSubject);

        addSomeDelay();

        publishSubject.subscribe(subscriber1);
        publishSubject.subscribe(subscriber2);

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
