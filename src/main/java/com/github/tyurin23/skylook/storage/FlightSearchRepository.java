package com.github.tyurin23.skylook.storage;

import com.github.tyurin23.skylook.storage.domain.FlightSearchResult;
import org.springframework.data.repository.Repository;

/**
 * Created by Y. Tyurin <tyurin23@gmail.com> on 19.02.17.
 */
public interface FlightSearchRepository extends Repository<FlightSearchResult, String> {
}
