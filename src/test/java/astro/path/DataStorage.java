package astro.path;

import astro.path.objects.*;

import tools.jackson.core.JacksonException;
import tools.jackson.databind.ObjectMapper;
import tools.jackson.databind.exc.InvalidDefinitionException;
import tools.jackson.databind.exc.MismatchedInputException;

import tools.jackson.core.type.TypeReference;
import tools.jackson.core.JacksonException;

import java.io.InputStream;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.File;
import java.io.FileNotFoundException;

import java.util.List;
import java.util.ArrayList;


public class DataStorage {
	public static void main(String[] args) {
		System.out.println("Hello There!");
		ObjectMapper mapper = new ObjectMapper();
		try {
			// Declaring Filepath
			File storageFile = new File("src/test/resources/Spacecraft.apos.json");
			storageFile.createNewFile();
			// Creating Sample data for test input
			List<Spacecraft> mySCList = new ArrayList<Spacecraft>();
			Spacecraft mySC = new Spacecraft("Mike Hunterz");
			mySC.addSCPart(new SCPCockpit());
			mySC.addSCPart(new SCPFuelTank());
			mySC.addSCPart(new SCPThruster());
			mySCList.add(mySC);
			// Output Stream Init
			OutputStream outputStream = 
					new FileOutputStream(storageFile);
			// Output data into file
			mapper
			.writerWithDefaultPrettyPrinter()
			.writeValue(outputStream, mySCList);
			outputStream.close();
			
			
			// Input Stream init
			InputStream inputStream = new FileInputStream(storageFile);
			// Creating Mapping Reference for proper input
			TypeReference<List<Spacecraft>> typeReference = new TypeReference<List<Spacecraft>>() {};
			// Creating integratable Dataset 
			List<Spacecraft> SCList = mapper.readValue(inputStream, typeReference);
			// Basic Object handling
			for (Spacecraft SC : SCList) {
				System.out.println("Spacecraft '" + SC.getName() +
						"' has " + SC.getSCPList().size() + " Parts");
			}
			inputStream.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (InvalidDefinitionException e) {
			e.printStackTrace();
		} catch (MismatchedInputException e) {
			e.printStackTrace();
		} catch (JacksonException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
