package com.example.dimuch.task2_retrofit.data.local.mappers;

/**
 * Created by Dimuch on 13.10.2017.
 */

public interface Mapper<A, B> {
  B transform(A obj) throws RuntimeException;
}