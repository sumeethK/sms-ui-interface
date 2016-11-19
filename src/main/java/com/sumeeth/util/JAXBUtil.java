/**
 * 
 */
package com.sumeeth.util;

import java.io.File;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.apache.log4j.Logger;

import com.sumeeth.model.FileInfoList;

/**
 * @author sumeeth kumar kanojia
 * 
 */
public class JAXBUtil {
	private final static Logger logger = Logger
			.getLogger(JAXBUtil.class);
	private final static String FILE_BASE_PATH = "I:\\workSpaceSpring\\SoftwareManageSystem\\src\\main\\resources\\data\\";

	private JAXBUtil() {
	}

	public static void marshalFileList(
			FileInfoList fileInfoList) {
		logger.info("Method Naame : marshalFileList");
		try {
			JAXBContext jxbContext = JAXBContext
					.newInstance(FileInfoList.class);
			Marshaller marshaller = jxbContext
					.createMarshaller();
			marshaller.setProperty(
					Marshaller.JAXB_FORMATTED_OUTPUT, true);
			StringWriter stringWriter = new StringWriter();
			marshaller.marshal(fileInfoList, stringWriter);
			if (logger.isDebugEnabled()) {
				logger.debug(stringWriter.toString());
			}
			marshaller.marshal(fileInfoList, new File(
					FILE_BASE_PATH + "file_info_list.xml"));

			logger.info("Sucessfully marshalled fileList into file_info_list.xml");
		} catch (JAXBException e) {
			logger.error("Unable to persist ");
			logger.error(e.getMessage());
		}

	}

	public static FileInfoList unmarshalFileList() {
		logger.info("Method Naame : unmarshalFileList");
		FileInfoList fileInfoList = new FileInfoList();
		try {
			JAXBContext jxbContext = JAXBContext
					.newInstance(FileInfoList.class);
			File file = new File(FILE_BASE_PATH
					+ "file_info_list.xml");
			fileInfoList = (FileInfoList) jxbContext
					.createUnmarshaller().unmarshal(file);

			if (logger.isDebugEnabled()) {
				logger.debug(fileInfoList);
			}

			logger.info("Sucessfully unmarshalled fileList from file_info_list.xml");
		} catch (JAXBException e) {
			logger.error("Unable to unmarshall from file  ");
			logger.error(e.getMessage());
		}
		return fileInfoList;

	}

	public static void marshalFileList(
			FileInfoList fileInfoList, String fileName) {
		logger.info("Method Naame : marshalFileList");
		try {
			JAXBContext jxbContext = JAXBContext
					.newInstance(FileInfoList.class);
			Marshaller marshaller = jxbContext
					.createMarshaller();
			marshaller.setProperty(
					Marshaller.JAXB_FORMATTED_OUTPUT, true);
			StringWriter stringWriter = new StringWriter();
			marshaller.marshal(fileInfoList, stringWriter);
			if (logger.isDebugEnabled()) {
				logger.debug(stringWriter.toString());
			}
			marshaller.marshal(fileInfoList, new File(
					FILE_BASE_PATH + fileName + ".xml"));

			logger.info("Sucessfully marshalled fileList into "
					+ fileName + ".xml");
		} catch (JAXBException e) {
			logger.error("Unable to persist in to : "
					+ fileName);
			logger.error(e.getMessage());
			e.printStackTrace();
		}

	}

	public static FileInfoList unmarshalFileList(
			String fileName) {
		logger.info("Method Name : unmarshalFileList");
		FileInfoList fileInfoList = new FileInfoList();
		try {
			JAXBContext jxbContext = JAXBContext
					.newInstance(FileInfoList.class);
			File file = new File(FILE_BASE_PATH + fileName
					+ ".xml");
			fileInfoList = (FileInfoList) jxbContext
					.createUnmarshaller().unmarshal(file);

			if (logger.isDebugEnabled()) {

				logger.debug(fileInfoList);
			}

			logger.info("Sucessfully unmarshalled fileList from "
					+ fileName + ".xml");
		} catch (JAXBException e) {
			logger.error("Unable to read From : "
					+ fileName);
			logger.error(e.getMessage());
			e.printStackTrace();
		}
		return fileInfoList;

	}

}
