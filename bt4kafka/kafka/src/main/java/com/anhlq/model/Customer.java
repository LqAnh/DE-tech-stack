package com.anhlq.model;

import com.opencsv.bean.CsvBindByPosition;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Customer {

    @CsvBindByPosition(position = 0)
    int id;

    @CsvBindByPosition(position = 1)
    int numOrder;

    @CsvBindByPosition(position = 2)
    int age;

    @CsvBindByPosition(position = 3)
    String phoneNum;
}
