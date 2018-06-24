package test;

import java.util.Random;

import org.apache.log4j.Logger;
import org.junit.Test;

public class TestLog4j {

	private Logger logger= Logger.getLogger(TestLog4j.class);
	
	@Test
	public void testLog4j() {
		
		logger.info("1、准备生成随机数");
		int r = new Random().nextInt(20);
		int num = r%2 ==0?0:r;
		
		try {
			logger.info("2、成功生成随机数，当前随机数是："+r);
			logger.info("当前的随机数是："+r);
			int result = r/num;
			logger.info("3、使用随机数进行除法运算的结果是：" + result);
		} catch (ArithmeticException e) {
			logger.debug("发生了算数异常",e);
			logger.warn("发生了算数运算异常");
		}
		
		//调试级别的信息一般用于程序开发过程中使用或程序发生问题后需要程序调试时才打开调试开关
		//输出的内容为用于调试程序使用的内容
		logger.debug("log4j调试信息");
		
		//对于程序运行过程中的重要步骤或流程，可以使用info级别输出相关的提示
		logger.info("log4j提示信息");
		
		//当程序发生错误或程序校验到某些重要数据不合法时，可以输出warn或error级别的提示
		//可以根据程序需要，选择不同级别
		logger.warn("log4j警告信息");
		logger.error("log4j错误信息");
		
		//一般用于记录不可修复的错误，类似于error错误
		logger.fatal("log4j严重错误信息");
	}
}
