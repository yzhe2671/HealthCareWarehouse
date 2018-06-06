package COMP5703.cp20.group2.service;

import org.springframework.stereotype.Service;

import weka.classifiers.bayes.NaiveBayes;
import weka.core.DenseInstance;
import weka.core.Instance;
import weka.core.Instances;
import weka.experiment.InstanceQuery;
import weka.filters.Filter;
import weka.filters.unsupervised.instance.NonSparseToSparse;

@Service
public class predictManager {
	
	public String DiseasePredict(int age, String gender, String race,
			String smoking, String alcohol, String softdrink, String exercise) {
		String predict=null;
		if (race.equals("Chinese")) {
			race="CHINESE/????";
		}
		
		try {
			InstanceQuery query= new InstanceQuery();
			query.setDatabaseURL("jdbc:mysql://localhost:3306/healthcareData");
			query.setUsername("root");
			query.setPassword("qqd2dHGH");
			query.setQuery("select IFNULL(age,0), gender, race, if(smoking=1, 'yes','no'), "
					+ "if(alcohol=1, 'yes','no'), if(softdrink=1, 'yes','no'),"
					+ " if(exercise=1, 'yes','no'), if(ifhavedisease=1, 'yes','no') from patient;");
			Instances originalinstances = (Instances) query.retrieveInstances();
			NonSparseToSparse sp= new NonSparseToSparse();
			sp.setInputFormat(originalinstances);
			Instances instances  = Filter.useFilter(originalinstances,sp);
			instances.setClassIndex(instances.numAttributes()-1);
			NaiveBayes nb = new NaiveBayes();
			nb.buildClassifier(instances);
		
			
			Instance patientinstance=new DenseInstance(8);
			patientinstance.setDataset(instances);
			patientinstance.setValue(0, age);
			patientinstance.setValue(1, gender);
			patientinstance.setValue(2, race);
			patientinstance.setValue(3, smoking);
			patientinstance.setValue(4, alcohol);
			patientinstance.setValue(5, softdrink);
			patientinstance.setValue(6, exercise);
			
			double predictvalue=nb.classifyInstance(patientinstance);
			predict=instances.classAttribute().value((int)predictvalue);
				
			query.close();
						
		}catch(Exception e){e.printStackTrace();}
		
		return predict;
		
	}

}
