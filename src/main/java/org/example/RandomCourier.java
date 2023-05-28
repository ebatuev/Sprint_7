package org.example;

import org.apache.commons.lang3.RandomStringUtils;

public class RandomCourier extends Courier {

    // Код для генерации произвольных\рандомных значений для логина, пароля и имени курьера
    private static final String RANDOM_LOGIN = RandomStringUtils.random(10, true, false);

    private static final String RANDOM_PASSWORD = RandomStringUtils.random(10, true, true);

    private static final String RANDOM_NAME = RandomStringUtils.random(10, true, false);

    public RandomCourier() {
        super(RANDOM_LOGIN, RANDOM_PASSWORD, RANDOM_NAME);
    }

}



