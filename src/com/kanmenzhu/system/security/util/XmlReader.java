package com.kanmenzhu.system.security.util;
/**
 * ��ָ����xml�ļ���ȡ������Ϣ���������ṹ��
 */
import java.io.*; 
import java.util.*; 
import org.w3c.dom.*; 
import javax.xml.parsers.*; 

public class XmlReader {
	private List retu;
	private String val;
	private DocumentBuilderFactory factory;
	private DocumentBuilder builder;
	private Document doc;
	private File f;
	private NodeList nl;


	/**
	 * ����ָ���ڵ�ָ�������������Ϣ
	 * @param xmlpath xml�ļ����ڵľ��·��
	 * @param prd prd:String[] prd[0]ֻ�ܱ���һ�����ڵ����,prd[1-n]Ϊ���ڵ����ӽڵ���ơ�
	 * @return
	 */
	public List read2Level(String xmlpath,String prd[]){ //��ȡָ����Ƽ��������
		long lasting =System.currentTimeMillis(); 
		f=new File(xmlpath); 
		retu = new ArrayList();
		try{ 
			f=new File(xmlpath);
			factory=DocumentBuilderFactory.newInstance(); 
			builder=factory.newDocumentBuilder(); 
			doc = builder.parse(f); 
			nl = doc.getElementsByTagName(prd[0]); 
			for (int i=0;i<nl.getLength();i++){ 
				Map map=new HashMap();
				for(int j=1;j<prd.length;j++){
					val=doc.getElementsByTagName(prd[j]).item(i).getFirstChild().getNodeValue();
					map.put(prd[j], val);
				}
			retu.add(map);
			
			} 
			return retu;
		}catch(Exception e){ 
			e.printStackTrace(); 
			return null;
		}
	}

	/**
	 * ����ָ���������ڵ�ֵ
	 * @param xmlpath xml�ļ����·��
	 * @param prd Ҫ���ص�һ���ڵ����
	 * @return ���ظýڵ��²���ֵ��
	 */
	public String read1Level(String xmlpath,String prd){
		Map map=new HashMap();
		f=new File(xmlpath); 
		try{ 
			f=new File(xmlpath);
			factory=DocumentBuilderFactory.newInstance(); 
			builder=factory.newDocumentBuilder(); 
			doc = builder.parse(f); 
		return doc.getElementsByTagName(prd).item(0).getFirstChild().getNodeValue();
		}catch(Exception e){
			e.printStackTrace(); 
			return null;
		}
	}
	
}
