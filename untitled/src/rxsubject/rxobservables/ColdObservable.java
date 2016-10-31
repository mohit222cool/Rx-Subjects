package rxsubject.rxobservables;

import rx.Observable;
import rx.Subscriber;

/**
 * Created by mohit.sharma on 10/18/16.
 */
public class ColdObservable {

    public static void main(String[] args) {

        Observable<Integer> cold = Observable.create(subscriber -> {
            for (int i = 0; i <= 1; i++) {
                System.out.println("Observable Emit " + i);
                subscriber.onNext(i);
            }
        });

        cold.subscribe(subscriber1);
        cold.subscribe(subscriber2);
    }

    private static Subscriber<Integer> subscriber1 = new Subscriber<Integer>() {
        @Override
        public void onCompleted() {

        }

        @Override
        public void onError(Throwable throwable) {

        }

        @Override
        public void onNext(Integer integer) {
            System.out.println("Subscriber 1 :" + integer);
        }
    };

    private static Subscriber<Integer> subscriber2 = new Subscriber<Integer>() {
        @Override
        public void onCompleted() {

        }

        @Override
        public void onError(Throwable throwable) {

        }

        @Override
        public void onNext(Integer integer) {
            System.out.println("Subscriber 2 :" + integer);
        }
    };
}