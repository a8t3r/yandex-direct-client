package ru.cultserv.adv.yandex.direct;

import ru.cultserv.adv.yandex.direct.methods.*;

import java.io.Closeable;

public interface YandexDirect extends Closeable {

	/**
	 * Доступ к методам для работы с рекламными кампаниями
	 */
	Campaigns campaigns();
	
	/**
	 * Доступ к методам для работы с объявлениями
	 */
	Banners banners();

	Forecasts forecasts();

	Vocabularies vocabularies();

	Utils utils();

    WordStats wordstats();

}
