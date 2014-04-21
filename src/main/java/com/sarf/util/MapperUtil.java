package com.sarf.util;

import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;

public class MapperUtil {

	private static Mapper mapper;

	private static MapperUtil myMapper;

	private MapperUtil() {

	}

	public static synchronized Mapper getMapper() {
		if (myMapper == null) {
			final List<String> mappingFiles = new ArrayList<String>();
			mappingFiles.add("META-INF/dozer-bean-mappings.xml");
			mapper = new DozerBeanMapper(mappingFiles);
			myMapper = new MapperUtil();
		}
		return mapper;
	}

}
