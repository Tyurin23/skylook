package com.github.tyurin23.skylook.skyscanner;

import com.github.tyurin23.skylook.skyscanner.dto.PollResponseData;
import com.github.tyurin23.skylook.skyscanner.dto.ResponseData;

/**
 * Created by Y. Tyurin <tyurin23@gmail.com> on 08.02.17.
 */
public interface SkyRepository {

	ResponseData getLocales();

	ResponseData getCurrencies();

	String createSession(SessionParameters parameters);

	PollResponseData pollSession(String location);
}
