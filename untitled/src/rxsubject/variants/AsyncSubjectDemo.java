package rxsubject.variants;

import rx.Observable;
import rx.Subscriber;
import rx.subjects.AsyncSubject;

/**
 * Created by mohit.sharma on 10/19/16.
 */
public class AsyncSubjectDemo {
    public static void main(String[] args) {

        Observable<Integer> cold = Observable.create(subscriber -> {
            for (int i = 0; i <= 2; i++) {
                System.out.println("Source Emits : " + i);
                subscriber.onNext(i);
            }
            subscriber.onCompleted();
        });

        AsyncSubject<Integer> asyncSubject = AsyncSubject.create();
        cold.subscribe(asyncSubject);
        asyncSubject.subscribe(subscriber1);
        asyncSubject.subscribe(subscriber2);
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
            System.out.println("Subscriber 1 : " + integer);
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
            System.out.println("Subscriber 2 : " + integer);
        }
    };




}
