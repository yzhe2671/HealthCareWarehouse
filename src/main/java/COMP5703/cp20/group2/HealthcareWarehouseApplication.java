package COMP5703.cp20.group2;


import java.sql.ResultSet;


import org.apache.ibatis.type.MappedTypes;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

import COMP5703.cp20.group2.domain.patient;
import weka.classifiers.bayes.NaiveBayes;
import weka.core.DenseInstance;
import weka.core.Instance;
import weka.core.Instances;
import weka.experiment.InstanceQuery;
import weka.filters.unsupervised.instance.NonSparseToSparse;
import weka.filters.*;

@SpringBootApplication
@MapperScan("COMP5703.cp20.group2.mapper")
@ServletComponentScan
public class HealthcareWarehouseApplication {

	public static void main(String[] args) {
		SpringApplication.run(HealthcareWarehouseApplication.class, args);
		
	}
}
