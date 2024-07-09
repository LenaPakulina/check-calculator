package main.java.ru.clevertec.check.service;

import main.java.ru.clevertec.check.dto.CheckDTO;
import main.java.ru.clevertec.check.utils.argparser.LaunchParams;

public interface CheckService {
    public CheckDTO createCheck(LaunchParams options);
}
