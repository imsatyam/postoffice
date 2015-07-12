# postoffice
Utility to send an email

# Usage
To use this email utility in the Spring application, please add following configuration to application-context.xml

<bean id="mailPropertiesConfigurer" class="org.springframework.beans.factory.config.PropertiesFactoryBean">
  <property name="location" value="classpath:mail.properties"/>
</bean>

<bean id="mailPropertyPlaceholder" class="org.springframework.beans.factory.config.PropertyPlaceholderConfigurer">
  <property name="properties" ref="mailPropertiesConfigurer"/>
</bean>

<bean id="mailSender" class="org.springframework.mail.javamail.JavaMailSenderImpl">
  <property name="host" ref="${mail.smtp.host}"/>
</bean>
