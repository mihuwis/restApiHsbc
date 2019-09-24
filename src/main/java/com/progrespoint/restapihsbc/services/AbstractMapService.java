package com.progrespoint.restapihsbc.services;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstractMapService<ID extends Long, T> {
    Map<Long, T> map = new HashMap<>();
}
