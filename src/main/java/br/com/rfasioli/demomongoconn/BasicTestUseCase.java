package br.com.rfasioli.demomongoconn;

import java.util.List;

public interface BasicTestUseCase<T> {
    T save(T source);
    List<T> find();
}