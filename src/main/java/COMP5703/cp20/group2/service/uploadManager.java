package COMP5703.cp20.group2.service;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import COMP5703.cp20.group2.domain.drugusage;
import COMP5703.cp20.group2.domain.patient;
import COMP5703.cp20.group2.domain.stroke_lab;
import COMP5703.cp20.group2.mapper.insertMapper;
import COMP5703.cp20.group2.mapper.patientMapper;

@Service
public class uploadManager {
	
	@Autowired
	insertMapper insertmapper;
	
	@Autowired
	patientMapper patientmapper;
	
	//File is sent as a MultipartFile along with the request, and read by this function
	public void readfile(MultipartFile file, String username, String disease) {
		//A HashMap is built to store different List of Data
		Map filemap = new HashMap();
    	List<patient> patientlist= new ArrayList<patient>();
    	List<stroke_lab> strokelablist= new ArrayList<stroke_lab>();
    	List<drugusage> druglist= new ArrayList<drugusage>();

    try {
		BufferedInputStream fis = new BufferedInputStream(file.getInputStream());
		//This is the workbook, which represents the excel file
		Workbook wb = new XSSFWorkbook(fis);
		   FormulaEvaluator formulaevaluator = wb.getCreationHelper().createFormulaEvaluator();
		   //Each sheet in the workbook will be scanned
		for(Sheet sheet: wb) {
			//Reading each row in every sheet
		for(Row row: sheet) {
			if(row.getRowNum()==0) {
				continue;
			}
			if(row.getRowNum()==1) {
				if(sheet.getRow(0).getCell(0)==null) {
					continue;
				}
				else {}
			}
			// A unique Id is assigned to a new patient, as the primary key
			String uuid=UUID.randomUUID().toString();
			patient patient = new patient();
			stroke_lab strokelab = new stroke_lab();
			drugusage druguse = new drugusage();
			patient.setPatientID(uuid);
			patient.setSource(username);
			patient.setDisease(disease);
			strokelab.setPatientID(uuid);
			druguse.setPatientID(uuid);
			//Reading each cell of rows, determine whether the field name is useful
			for(Cell cell: row) {
				if(columnName(cell).contains("iim_no")){
				switch(formulaevaluator.evaluateInCell(cell).getCellTypeEnum()) {
				case NUMERIC:
					patient.setIIM_NO(cell.getNumericCellValue());
					System.out.print(cell.getNumericCellValue()+"\t\t");
					break;
				case STRING:
					System.out.print("\t\t\t\t");
					break;
				case _NONE:
					System.out.print("\t\t\t\t");
				    break; 
				case BLANK:
					System.out.print("\t\t\t\t");
				  }
		     	}
				
				else if(columnName(cell).contains("age")) {
					switch(formulaevaluator.evaluateInCell(cell).getCellTypeEnum()) {
					case NUMERIC:
						patient.setAge(cell.getNumericCellValue());
						System.out.print(cell.getNumericCellValue()+"\t\t");
						break;
					case STRING:
						System.out.print("\t\t\t\t");
						break;
					case _NONE:
						System.out.print("\t\t\t\t");
					    break; 
					case BLANK:
						System.out.print("\t\t\t\t");
					  }
					
					
				}else if(columnName(cell).contains("gender")||columnName(cell).contains("sex")) {
					switch(formulaevaluator.evaluateInCell(cell).getCellTypeEnum()) {
					case NUMERIC:
						System.out.print("\t\t\t\t");
						break;
					case STRING:
						patient.setGender(cell.getStringCellValue());
						System.out.print(cell.getStringCellValue()+"\t\t");
						break;
					case _NONE:
						System.out.print("\t\t\t\t");
					    break; 
					case BLANK:
						System.out.print("\t\t\t\t");
					  }
					
					
				}else if(columnName(cell).contains("name")) {
					switch(formulaevaluator.evaluateInCell(cell).getCellTypeEnum()) {
					case NUMERIC:
						System.out.print("\t\t\t\t");
						break;
					case STRING:
						patient.setFullname(cell.getStringCellValue());
						System.out.print(cell.getStringCellValue()+"\t\t");
						break;
					case _NONE:
						System.out.print("\t\t\t\t");
					    break; 
					case BLANK:
						System.out.print("\t\t\t\t");
					  }
					
					
				}else if(columnName(cell).contains("race")) {
					switch(formulaevaluator.evaluateInCell(cell).getCellTypeEnum()) {
					case NUMERIC:
						System.out.print("\t\t\t\t");
						break;
					case STRING:
						patient.setRace(cell.getStringCellValue());
						System.out.print(cell.getStringCellValue()+"\t\t");
						break;
					case _NONE:
						System.out.print("\t\t\t\t");
					    break; 
					case BLANK:
						System.out.print("\t\t\t\t");
					  }
					
					
				}else if(columnName(cell).contains("date")&columnName(cell).contains("birth")
						&columnName(cell).contains("yyyy")						) {
					switch(formulaevaluator.evaluateInCell(cell).getCellTypeEnum()) {
					case NUMERIC:
						System.out.print("\t\t\t\t");
						break;
					case STRING:
						patient.setDateOfBirth(cell.getStringCellValue());
						System.out.print(cell.getStringCellValue()+"\t\t");
						break;
					case _NONE:
						System.out.print("\t\t\t\t");
					    break; 
					case BLANK:
						System.out.print("\t\t\t\t");
					  }
					
				}else if(columnName(cell).contains("date")&columnName(cell).contains("admission")
						&columnName(cell).contains("yyyy")						) {
					switch(formulaevaluator.evaluateInCell(cell).getCellTypeEnum()) {
					case NUMERIC:
						System.out.print("\t\t\t\t");
						break;
					case STRING:
						patient.setAdmissionDate(cell.getStringCellValue());
						System.out.print(cell.getStringCellValue()+"\t\t");
						break;
					case _NONE:
						System.out.print("\t\t\t\t");
					    break; 
					case BLANK:
						System.out.print("\t\t\t\t");
					  }
					
					
				}else if(columnName(cell).contains("date")&columnName(cell).contains("discharge")
						&columnName(cell).contains("yyyy")						) {
					switch(formulaevaluator.evaluateInCell(cell).getCellTypeEnum()) {
					case NUMERIC:
						System.out.print("\t\t\t\t");
						break;
					case STRING:
						patient.setDischargeDate(cell.getStringCellValue());
						System.out.print(cell.getStringCellValue()+"\t\t");
						break;
					case _NONE:
						System.out.print("\t\t\t\t");
					    break; 
					case BLANK:
						System.out.print("\t\t\t\t");
					  }
					
					
				}else if(columnName(cell).contains("match")&columnName(cell).contains("cmis")) {
					switch(formulaevaluator.evaluateInCell(cell).getCellTypeEnum()) {
					case NUMERIC:
						System.out.print("\t\t\t\t");
						break;
					case STRING:
						if(cell.getStringCellValue().toLowerCase().contains("without")) {
						patient.setIfhavedisease(false);}
						else {
							patient.setIfhavedisease(true);
						}
						System.out.print(cell.getStringCellValue()+"\t\t");
						break;
					case _NONE:
						System.out.print("\t\t\t\t");
					    break; 
					case BLANK:
						System.out.print("\t\t\t\t");
					  }
					
					
				}else if(columnName(cell).contains("smok")) {
					switch(formulaevaluator.evaluateInCell(cell).getCellTypeEnum()) {
					case NUMERIC:
						System.out.print("\t\t\t\t");
						break;
					case STRING:
						if(cell.getStringCellValue().toLowerCase().contains("y")) {
						patient.setSmoking(true);}
						if(cell.getStringCellValue().toLowerCase().contains("n")){
							patient.setSmoking(false);
						}
						System.out.print(cell.getStringCellValue()+"\t\t");
						break;
					case _NONE:
						System.out.print("\t\t\t\t");
					    break; 
					case BLANK:
						System.out.print("\t\t\t\t");
					  }
					
					
				}else if(columnName(cell).contains("alcohol")) {
					switch(formulaevaluator.evaluateInCell(cell).getCellTypeEnum()) {
					case NUMERIC:
						System.out.print("\t\t\t\t");
						break;
					case STRING:
						if(cell.getStringCellValue().toLowerCase().contains("y")) {
						patient.setAlcohol(true);}
						if(cell.getStringCellValue().toLowerCase().contains("n")){
							patient.setAlcohol(false);
						}
						System.out.print(cell.getStringCellValue()+"\t\t");
						break;
					case _NONE:
						System.out.print("\t\t\t\t");
					    break; 
					case BLANK:
						System.out.print("\t\t\t\t");
					  }
					
					
				}else if(columnName(cell).contains("soft")&&columnName(cell).contains("drink")) {
					switch(formulaevaluator.evaluateInCell(cell).getCellTypeEnum()) {
					case NUMERIC:
						System.out.print("\t\t\t\t");
						break;
					case STRING:
						if(cell.getStringCellValue().toLowerCase().contains("y")) {
						patient.setSoftdrink(true);}
						if(cell.getStringCellValue().toLowerCase().contains("n")){
							patient.setSoftdrink(false);
						}
						System.out.print(cell.getStringCellValue()+"\t\t");
						break;
					case _NONE:
						System.out.print("\t\t\t\t");
					    break; 
					case BLANK:
						System.out.print("\t\t\t\t");
					  }
					
					
				}else if(columnName(cell).contains("exercise")) {
					switch(formulaevaluator.evaluateInCell(cell).getCellTypeEnum()) {
					case NUMERIC:
						System.out.print("\t\t\t\t");
						break;
					case STRING:
						if(cell.getStringCellValue().toLowerCase().contains("y")) {
						patient.setExercise(true);}
						if(cell.getStringCellValue().toLowerCase().contains("n")){
							patient.setExercise(false);
						}
						System.out.print(cell.getStringCellValue()+"\t\t");
						break;
					case _NONE:
						System.out.print("\t\t\t\t");
					    break; 
					case BLANK:
						System.out.print("\t\t\t\t");
					  }
					
					
				}else if(columnName(cell).contains("hba1c")&columnName(cell).contains("0")) {
					switch(formulaevaluator.evaluateInCell(cell).getCellTypeEnum()) {
					case NUMERIC:
						strokelab.setHBA1C0(cell.getNumericCellValue());
						System.out.print(cell.getNumericCellValue()+"\t\t");
						break;
					case STRING:
						System.out.print("\t\t\t\t");
						break;
					case _NONE:
						System.out.print("\t\t\t\t");
					    break; 
					case BLANK:
						System.out.print("\t\t\t\t");
					  }
					
					
				}else if(columnName(cell).contains("hba1c")&columnName(cell).contains("3")) {
					switch(formulaevaluator.evaluateInCell(cell).getCellTypeEnum()) {
					case NUMERIC:
						strokelab.setHBA1C3(cell.getNumericCellValue());
						System.out.print(cell.getNumericCellValue()+"\t\t");
						break;
					case STRING:
						System.out.print("\t\t\t\t");
						break;
					case _NONE:
						System.out.print("\t\t\t\t");
					    break; 
					case BLANK:
						System.out.print("\t\t\t\t");
					  }
					
					
				}else if(columnName(cell).contains("hba1c")&columnName(cell).contains("12")) {
					switch(formulaevaluator.evaluateInCell(cell).getCellTypeEnum()) {
					case NUMERIC:
						strokelab.setHBA1C12(cell.getNumericCellValue());
						System.out.print(cell.getNumericCellValue()+"\t\t");
						break;
					case STRING:
						System.out.print("\t\t\t\t");
						break;
					case _NONE:
						System.out.print("\t\t\t\t");
					    break; 
					case BLANK:
						System.out.print("\t\t\t\t");
					  }
					
					
				}else if(columnName(cell).contains("glucose")&columnName(cell).contains("0")) {
					switch(formulaevaluator.evaluateInCell(cell).getCellTypeEnum()) {
					case NUMERIC:
						strokelab.setGlucose0(cell.getNumericCellValue());
						System.out.print(cell.getNumericCellValue()+"\t\t");
						break;
					case STRING:
						System.out.print("\t\t\t\t");
						break;
					case _NONE:
						System.out.print("\t\t\t\t");
					    break; 
					case BLANK:
						System.out.print("\t\t\t\t");
					  }
					
					
				}else if(columnName(cell).contains("glucose")&columnName(cell).contains("3")) {
					switch(formulaevaluator.evaluateInCell(cell).getCellTypeEnum()) {
					case NUMERIC:
						strokelab.setGlucose3(cell.getNumericCellValue());
						System.out.print(cell.getNumericCellValue()+"\t\t");
						break;
					case STRING:
						System.out.print("\t\t\t\t");
						break;
					case _NONE:
						System.out.print("\t\t\t\t");
					    break; 
					case BLANK:
						System.out.print("\t\t\t\t");
					  }
					
					
				}else if(columnName(cell).contains("glucose")&columnName(cell).contains("12")) {
					switch(formulaevaluator.evaluateInCell(cell).getCellTypeEnum()) {
					case NUMERIC:
						strokelab.setGlucose12(cell.getNumericCellValue());
						System.out.print(cell.getNumericCellValue()+"\t\t");
						break;
					case STRING:
						System.out.print("\t\t\t\t");
						break;
					case _NONE:
						System.out.print("\t\t\t\t");
					    break; 
					case BLANK:
						System.out.print("\t\t\t\t");
					  }
					
					
				}else if(columnName(cell).contains("tri")&columnName(cell).contains("0")) {
				  switch(formulaevaluator.evaluateInCell(cell).getCellTypeEnum()) {
				  case NUMERIC:
					strokelab.setTRI0(cell.getNumericCellValue());
					System.out.print(cell.getNumericCellValue()+"\t\t");
					break;
				  case STRING:
						System.out.print("\t\t\t\t");
					break;
				  case _NONE:
						System.out.print("\t\t\t\t");
				    break; 
				  case BLANK:
						System.out.print("\t\t\t\t");
				  }
				  	
			
			
			
		}else if(columnName(cell).contains("tri")&columnName(cell).contains("3")) {
			  switch(formulaevaluator.evaluateInCell(cell).getCellTypeEnum()) {
			  case NUMERIC:
				strokelab.setTRI3(cell.getNumericCellValue());
				System.out.print(cell.getNumericCellValue()+"\t\t");
				break;
			  case STRING:
					System.out.print("\t\t\t\t");
				break;
			  case _NONE:
					System.out.print("\t\t\t\t");
			    break; 
			  case BLANK:
					System.out.print("\t\t\t\t");
			  }
			  	
		
		
		
	}else if(columnName(cell).contains("tri")&columnName(cell).contains("12")) {
		  switch(formulaevaluator.evaluateInCell(cell).getCellTypeEnum()) {
		  case NUMERIC:
			strokelab.setTRI12(cell.getNumericCellValue());
			System.out.print(cell.getNumericCellValue()+"\t\t");
			break;
		  case STRING:
				System.out.print("\t\t\t\t");
			break;
		  case _NONE:
				System.out.print("\t\t\t\t");
		    break; 
		  case BLANK:
				System.out.print("\t\t\t\t");
		  }
		  	
	
	
	
}else if(columnName(cell).contains("hdl")&columnName(cell).contains("0")) {
	  switch(formulaevaluator.evaluateInCell(cell).getCellTypeEnum()) {
	  case NUMERIC:
		strokelab.setHDL0(cell.getNumericCellValue());
		System.out.print(cell.getNumericCellValue()+"\t\t");
		break;
	  case STRING:
			System.out.print("\t\t\t\t");
		break;
	  case _NONE:
			System.out.print("\t\t\t\t");
	    break; 
	  case BLANK:
			System.out.print("\t\t\t\t");
	  }
	  	



}else if(columnName(cell).contains("hdl")&columnName(cell).contains("3")) {
	  switch(formulaevaluator.evaluateInCell(cell).getCellTypeEnum()) {
	  case NUMERIC:
		strokelab.setHDL3(cell.getNumericCellValue());
		System.out.print(cell.getNumericCellValue()+"\t\t");
		break;
	  case STRING:
			System.out.print("\t\t\t\t");
		break;
	  case _NONE:
			System.out.print("\t\t\t\t");
	    break; 
	  case BLANK:
			System.out.print("\t\t\t\t");
	  }
	  	



}else if(columnName(cell).contains("hdl")&columnName(cell).contains("12")) {
	  switch(formulaevaluator.evaluateInCell(cell).getCellTypeEnum()) {
	  case NUMERIC:
		strokelab.setHDL12(cell.getNumericCellValue());
		System.out.print(cell.getNumericCellValue()+"\t\t");
		break;
	  case STRING:
			System.out.print("\t\t\t\t");
		break;
	  case _NONE:
			System.out.print("\t\t\t\t");
	    break; 
	  case BLANK:
			System.out.print("\t\t\t\t");
	  }
	  	



}else if(columnName(cell).contains("ldl")&columnName(cell).contains("0")) {
	  switch(formulaevaluator.evaluateInCell(cell).getCellTypeEnum()) {
	  case NUMERIC:
		strokelab.setLDL0(cell.getNumericCellValue());
		System.out.print(cell.getNumericCellValue()+"\t\t");
		break;
	  case STRING:
			System.out.print("\t\t\t\t");
		break;
	  case _NONE:
			System.out.print("\t\t\t\t");
	    break; 
	  case BLANK:
			System.out.print("\t\t\t\t");
	  }
	  	



}else if(columnName(cell).contains("ldl")&columnName(cell).contains("3")) {
	  switch(formulaevaluator.evaluateInCell(cell).getCellTypeEnum()) {
	  case NUMERIC:
		strokelab.setLDL0(cell.getNumericCellValue());
		System.out.print(cell.getNumericCellValue()+"\t\t");
		break;
	  case STRING:
			System.out.print("\t\t\t\t");
		break;
	  case _NONE:
			System.out.print("\t\t\t\t");
	    break; 
	  case BLANK:
			System.out.print("\t\t\t\t");
	  }
	  	



}else if(columnName(cell).contains("ldl")&columnName(cell).contains("12")) {
	  switch(formulaevaluator.evaluateInCell(cell).getCellTypeEnum()) {
	  case NUMERIC:
		strokelab.setLDL0(cell.getNumericCellValue());
		System.out.print(cell.getNumericCellValue()+"\t\t");
		break;
	  case STRING:
			System.out.print("\t\t\t\t");
		break;
	  case _NONE:
			System.out.print("\t\t\t\t");
	    break; 
	  case BLANK:
			System.out.print("\t\t\t\t");
	  }
	  	



}else if(columnName(cell).contains("cholest")&columnName(cell).contains("0")) {
				switch(formulaevaluator.evaluateInCell(cell).getCellTypeEnum()) {
				case NUMERIC:
					strokelab.setCholest0(cell.getNumericCellValue());
					System.out.print(cell.getNumericCellValue()+"\t\t");
					break;
				case STRING:
					System.out.print("\t\t\t\t");
					break;
				case _NONE:
					System.out.print("\t\t\t\t");
				    break; 
				case BLANK:
					System.out.print("\t\t\t\t");
		   }
				
			
			
			
		} else if (columnName(cell).contains("cholest")&columnName(cell).contains("3")) {
			switch(formulaevaluator.evaluateInCell(cell).getCellTypeEnum()) {
			case NUMERIC:
				strokelab.setCholest3(cell.getNumericCellValue());
				System.out.print(cell.getNumericCellValue()+"\t\t");
				break;
			case STRING:
				System.out.print("\t\t\t\t");
				break;
			case _NONE:
				System.out.print("\t\t\t\t");
			    break; 
			case BLANK:
				System.out.print("\t\t\t\t");
	   }
			
		
		
		
	}     else if(columnName(cell).contains("cholest")&columnName(cell).contains("12")) {
		switch(formulaevaluator.evaluateInCell(cell).getCellTypeEnum()) {
		case NUMERIC:
			strokelab.setCholest12(cell.getNumericCellValue());
			System.out.print(cell.getNumericCellValue()+"\t\t");
			break;
		case STRING:
			System.out.print("\t\t\t\t");
			break;
		case _NONE:
			System.out.print("\t\t\t\t");
		    break; 
		case BLANK:
			System.out.print("\t\t\t\t");
      }
		
	
	
	
      }else if(columnName(cell).contains("aspirin")) {
			switch(formulaevaluator.evaluateInCell(cell).getCellTypeEnum()) {
			case NUMERIC:
				druguse.setAspirin(cell.getNumericCellValue());
				System.out.print(cell.getNumericCellValue()+"\t\t");
				break;
			case STRING:
				System.out.print("\t\t\t\t");
				break;
			case _NONE:
				System.out.print("\t\t\t\t");
			    break; 
			case BLANK:
				System.out.print("\t\t\t\t");
			  }
			
			
		}else if(columnName(cell).contains("warfarin")) {
			switch(formulaevaluator.evaluateInCell(cell).getCellTypeEnum()) {
			case NUMERIC:
				druguse.setWarfarin(cell.getNumericCellValue());
				System.out.print(cell.getNumericCellValue()+"\t\t");
				break;
			case STRING:
				System.out.print("\t\t\t\t");
				break;
			case _NONE:
				System.out.print("\t\t\t\t");
			    break; 
			case BLANK:
				System.out.print("\t\t\t\t");
			  }
			
			
		}else if(columnName(cell).contains("clopidogrel")) {
			switch(formulaevaluator.evaluateInCell(cell).getCellTypeEnum()) {
			case NUMERIC:
				druguse.setClopidogrel(cell.getNumericCellValue());
				System.out.print(cell.getNumericCellValue()+"\t\t");
				break;
			case STRING:
				System.out.print("\t\t\t\t");
				break;
			case _NONE:
				System.out.print("\t\t\t\t");
			    break; 
			case BLANK:
				System.out.print("\t\t\t\t");
			  }
			
			
		}else {
    	  System.out.print(cell.getColumnIndex()+"not used\t\t");
      }
			
				}
			if(patient.getIIM_NO()==null) {
				continue;
			}
			if(patientmapper.selectUserPatient(patient.getIIM_NO(), patient.getSource())!=null) {
				continue;
			}
			
			insertmapper.patientInsert(patient);
			insertmapper.drugInsert(druguse);
			insertmapper.strokelabInsert(strokelab);
		
			
			
		}
		
    }
		
	} catch ( IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
   
	}
	
	public String columnName(Cell cell) {
		//judge if the first cell of first row is empty
		//then decide start reading from which row
		int r;
		if(cell.getSheet().getRow(0).getCell(0)==null){
			r=1;
		}else {
			r=0;
		}
		//judge whether the column name of the cell is valid
		if(cell.getSheet()
				.getRow(r)
				.getCell(cell.getColumnIndex())!=null) {
		//if valid then return the lowercase of column name
		return cell.getSheet().getRow(r).getCell(cell.getColumnIndex())
				.getRichStringCellValue().toString().toLowerCase();
		}
		//otherwise return a empty string
		else {
			return "";
		}
	}
	

    		

}
