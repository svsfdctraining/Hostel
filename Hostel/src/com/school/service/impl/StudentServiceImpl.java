package com.school.service.impl;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.school.bean.StudentBean;
import com.school.bean.StudentResult;
import com.school.dao.AdminDao;
import com.school.dao.StudentDao;
import com.school.dao.UtilityDao;
import com.school.pojo.Document;
import com.school.pojo.Organization;
import com.school.pojo.OrganizationMedium;
import com.school.pojo.Student;
import com.school.pojo.StudentClass;
import com.school.pojo.User;
import com.school.service.StudentService;
import com.school.util.bean.YearBean;

@Service(value = "studentService")
@Transactional(readOnly = false)
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentDao studentDao;
	@Autowired
	private UtilityDao utilityDao;
	@Override
	public void saveStudent(StudentBean studentbean, User user) {

		studentDao.saveStudent(studentbean, user);

	}

	@Override
	public StudentClass getclassfee(String stclass, User user) {
		return studentDao.getclassfee(stclass, user);

	}

	@Override
	public String saveDocument(StudentBean studentbean, User user) {
		Student student = studentbean.getStudent();
		Document document = new Document();
		document.setAdmno(student.getAdmissionNo());
		document.setStclass(student.getStclass());
		document.setOrgid(user.getOrgId());
		document.setContent(studentbean.getFiledata().getBytes());
		document.setFilename(studentbean.getFiledata().getOriginalFilename());

		if ("photo".equals(studentbean.getUploadtype())) {
			document.setDoctype("PHOTO");
			student.setPhotoname(studentbean.getFiledata()
					.getOriginalFilename());
			studentbean.setStudent(student);
			studentbean.setPhoto(document);
			return getPhotoPath(studentbean);
		}

		if ("rectc".equals(studentbean.getUploadtype())) {
			document.setDoctype("RECTC");
			student.setRectcname(studentbean.getFiledata()
					.getOriginalFilename());
			studentbean.setRectc(document);
		}
		if ("reccc".equals(studentbean.getUploadtype())) {
			document.setDoctype("RECCC");
			student.setRecccname(studentbean.getFiledata()
					.getOriginalFilename());
			studentbean.setReccc(document);
		}
		if ("recsc".equals(studentbean.getUploadtype())) {
			document.setDoctype("RECSC");
			student.setRecscname(studentbean.getFiledata()
					.getOriginalFilename());
			studentbean.setRecsc(document);
		}
		if ("recmm".equals(studentbean.getUploadtype())) {
			document.setDoctype("RECMM");
			student.setRecmmname(studentbean.getFiledata()
					.getOriginalFilename());
			studentbean.setRecmm(document);
		}

		if ("isstc".equals(studentbean.getUploadtype())) {
			document.setDoctype("ISSTC");
			student.setTcname(studentbean.getFiledata().getOriginalFilename());
			studentbean.setTc(document);
		}
		if ("isscc".equals(studentbean.getUploadtype())) {
			document.setDoctype("ISSCC");
			student.setCcname(studentbean.getFiledata().getOriginalFilename());
			studentbean.setCc(document);
		}
		if ("isssc".equals(studentbean.getUploadtype())) {
			document.setDoctype("ISSSC");
			student.setScname(studentbean.getFiledata().getOriginalFilename());
			studentbean.setSc(document);
		}
		if ("issmm".equals(studentbean.getUploadtype())) {
			document.setDoctype("ISSMM");
			student.setMmname(studentbean.getFiledata().getOriginalFilename());
			studentbean.setMm(document);
		}
		studentbean.setStudent(student);
		return null;
	}

	@Override
	public Long getAdmissionNo(User user) {

		return studentDao.getAdmissionNum(user);
	}

	@Override
	public Long getStudentRollNum(StudentBean studentbean, User user) {

		return studentDao.getStudentRollNum(studentbean, user);
	}

	@Override
	public List<StudentClass> getPrevclasses(StudentBean studentbean) {
		List<StudentClass> plist = new ArrayList<StudentClass>();
	/*	for (StudentClass sc : studentbean.getClasses()) {
			if (studentbean.getStudent().getStclass() > sc.getClassValue()) {
				plist.add(sc);
			}
		}*/
		return plist;
	}

	@Override
	public List<YearBean> getAcademicyears(User user, Organization organization) {
		List<YearBean> academicyears = new ArrayList<YearBean>();
		if(organization == null){
			Organization org = new Organization();
			org.setOrgId(user.getOrgId());
			
			organization = utilityDao.getOrganization(org);
		}
			
		int year = Calendar.getInstance().get(Calendar.YEAR);
		academicyears.add(new YearBean(((year) + "-" + (year + 1)), ((year)
				+ "-" + (year + 1))));
		for (int i = Calendar.getInstance().get(Calendar.YEAR); i >= organization
				.getYear(); i--) {
			academicyears.add(new YearBean(((i - 1) + "-" + i),
					((i - 1) + "-" + i)));
		}

		return academicyears;
	}

	@Override
	public List<Student> getSearchResults(StudentBean studentbean, User user) {

		return studentDao.getSearchResults(studentbean, user);
	}

	@Override
	public Student getStudent(Integer studentSeq) {

		return studentDao.getStudent(studentSeq);
	}

	@Override
	public void uploadFile(StudentBean studentbean, User user) {
		try {
			int i = 5;
			if (studentbean.getUploadfile().getOriginalFilename().toUpperCase()
					.endsWith(".XLS")) {
				HSSFWorkbook hssfworkbook = new HSSFWorkbook(studentbean
						.getUploadfile().getInputStream());
				HSSFSheet hssfsheet = hssfworkbook.getSheet("Previous");
				boolean status = true;
				List<StudentResult> results = new ArrayList<StudentResult>();
				while (i < hssfsheet.getLastRowNum()) {
					HSSFRow row = hssfsheet.getRow(i++);

					StudentResult result = new StudentResult();
					Student st = new Student();
					try {
						st.setAdmissionNo((long) row.getCell(0)
								.getNumericCellValue());
						result.setAdmissionnum((long) row.getCell(0)
								.getNumericCellValue());
						st.setJoinedDate(row.getCell(1).getDateCellValue());
						result.setRownum(i);
						st.setStclass( row.getCell(2).getStringCellValue());
						st.setSection(row.getCell(3).getStringCellValue());
						st.setMedium(row.getCell(4).getStringCellValue());
						st.setRollNo((long) row.getCell(5)
								.getNumericCellValue());
						st.setHostelFee((long) row.getCell(6)
								.getNumericCellValue());
						st.setHostelPaidfee((long) row.getCell(7)
								.getNumericCellValue());
						st.setHostelBalanceFee((long) row.getCell(8)
								.getNumericCellValue());
						st.setFirstname(row.getCell(9).getStringCellValue());
						st.setLastname(row.getCell(10).getStringCellValue());
						st.setGender(row.getCell(11).getStringCellValue());
						st.setBirthDate(row.getCell(12).getDateCellValue());
						st.setReligion(row.getCell(13).getStringCellValue());
						st.setCaste(row.getCell(14).getStringCellValue());
						st.setCastename(row.getCell(15).getStringCellValue());
						st.setParentType(row.getCell(16).getStringCellValue());
						st.setParentName(row.getCell(17).getStringCellValue());
						st.setMobile(new Double((double) row.getCell(18)
								.getNumericCellValue()).toString());
						st.setEmail(row.getCell(19).getStringCellValue());
						st.setOccupation(row.getCell(20).getStringCellValue());
						st.setPresentAddress(row.getCell(21)
								.getStringCellValue());
						st.setPremanentAddress(row.getCell(22)
								.getStringCellValue());
						st.setPrevschool(row.getCell(23).getStringCellValue());
						st.setPrevsStudClass((int) row.getCell(24)
								.getNumericCellValue());
						st.setPrevsStudyear(row.getCell(25)
								.getStringCellValue());
						st.setPrevsReleaveReason(row.getCell(26)
								.getStringCellValue());
						st.setPrevconduct(row.getCell(27).getStringCellValue());
						if ("yes".equalsIgnoreCase(row.getCell(28)
								.getStringCellValue())) {
							st.setRecTc(true);
						}
						if ("yes".equalsIgnoreCase(row.getCell(29)
								.getStringCellValue())) {
							st.setRecCC(true);
						}
						if ("yes".equalsIgnoreCase(row.getCell(30)
								.getStringCellValue())) {
							st.setRecSC(true);
						}
						if ("yes".equalsIgnoreCase(row.getCell(31)
								.getStringCellValue())) {
							st.setRecMarks(true);
						}
						if ("yes".equalsIgnoreCase(row.getCell(32)
								.getStringCellValue())) {
							st.setIssTc(true);
						}
						if ("yes".equalsIgnoreCase(row.getCell(33)
								.getStringCellValue())) {
							st.setIssCC(true);
						}
						if ("yes".equalsIgnoreCase(row.getCell(34)
								.getStringCellValue())) {
							st.setIssSC(true);
						}
						if ("yes".equalsIgnoreCase(row.getCell(35)
								.getStringCellValue())) {
							st.setIssMarks(true);
						}
						st.setLeaveReason(row.getCell(36).getStringCellValue());
						//st.setLeaveDate(row.getCell(37).getDateCellValue());
						st.setIssuedconduct(row.getCell(38)
								.getStringCellValue());
						st.setStatus(row.getCell(39).getStringCellValue());
						st.setOrgId(user.getOrgId());
						result.setStatus("success");
						st.setAcademicyear(studentbean.getAcademicyear());
					} catch (Exception e) {
						System.out.println(i + " " + e.getMessage());
						status = false;
						result.setStatus("fail");
					}
					
					
					result.setStudent(st);
					results.add(result);
					studentbean.setUploadresults(results);
					studentbean.setUploadstatus(status);

				}
			}
			if (studentbean.getUploadfile().getOriginalFilename().toUpperCase()
					.endsWith(".XLSX")) {
				XSSFWorkbook workbook = new XSSFWorkbook(studentbean
						.getUploadfile().getInputStream());
				XSSFSheet sheet = workbook.getSheet("Previous");
				boolean status = true;
				List<StudentResult> results = new ArrayList<StudentResult>();
				while (i < sheet.getLastRowNum()) {
					XSSFRow row = sheet.getRow(i++);
					StudentResult result = new StudentResult();
					Student st = new Student();
					try {
						st.setAdmissionNo((long) row.getCell(0)
								.getNumericCellValue());
						result.setAdmissionnum((long) row.getCell(0)
								.getNumericCellValue());
						st.setJoinedDate(row.getCell(1).getDateCellValue());
						result.setRownum(i);
						st.setStclass( row.getCell(2).getStringCellValue());
						st.setSection(row.getCell(3).getStringCellValue());
						st.setMedium(row.getCell(4).getStringCellValue());
						st.setRollNo((long) row.getCell(5)
								.getNumericCellValue());
						st.setHostelFee((long) row.getCell(6)
								.getNumericCellValue());
						st.setHostelPaidfee((long) row.getCell(7)
								.getNumericCellValue());
						st.setHostelBalanceFee((long) row.getCell(8)
								.getNumericCellValue());
						st.setFirstname(row.getCell(9).getStringCellValue());
						st.setLastname(row.getCell(10).getStringCellValue());
						st.setGender(row.getCell(11).getStringCellValue());
						st.setBirthDate(row.getCell(12).getDateCellValue());
						st.setReligion(row.getCell(13).getStringCellValue());
						st.setCaste(row.getCell(14).getStringCellValue());
						st.setCastename(row.getCell(15).getStringCellValue());
						st.setParentType(row.getCell(16).getStringCellValue());
						st.setParentName(row.getCell(17).getStringCellValue());
						st.setMobile(new Double((double) row.getCell(18)
								.getNumericCellValue()).toString());
						st.setEmail(row.getCell(19).getStringCellValue());
						st.setOccupation(row.getCell(20).getStringCellValue());
						st.setPresentAddress(row.getCell(21)
								.getStringCellValue());
						st.setPremanentAddress(row.getCell(22)
								.getStringCellValue());
						st.setPrevschool(row.getCell(23).getStringCellValue());
						st.setPrevsStudClass((int) row.getCell(24)
								.getNumericCellValue());
						st.setPrevsStudyear(row.getCell(25)
								.getStringCellValue());
						st.setPrevsReleaveReason(row.getCell(26)
								.getStringCellValue());
						st.setPrevconduct(row.getCell(27).getStringCellValue());
						if ("yes".equalsIgnoreCase(row.getCell(28)
								.getStringCellValue())) {
							st.setRecTc(true);
						}
						if ("yes".equalsIgnoreCase(row.getCell(29)
								.getStringCellValue())) {
							st.setRecCC(true);
						}
						if ("yes".equalsIgnoreCase(row.getCell(30)
								.getStringCellValue())) {
							st.setRecSC(true);
						}
						if ("yes".equalsIgnoreCase(row.getCell(31)
								.getStringCellValue())) {
							st.setRecMarks(true);
						}
						if ("yes".equalsIgnoreCase(row.getCell(32)
								.getStringCellValue())) {
							st.setIssTc(true);
						}
						if ("yes".equalsIgnoreCase(row.getCell(33)
								.getStringCellValue())) {
							st.setIssCC(true);
						}
						if ("yes".equalsIgnoreCase(row.getCell(34)
								.getStringCellValue())) {
							st.setIssSC(true);
						}
						if ("yes".equalsIgnoreCase(row.getCell(35)
								.getStringCellValue())) {
							st.setIssMarks(true);
						}
						st.setLeaveReason(row.getCell(36).getStringCellValue());
					//	st.setLeaveDate(row.getCell(37).getDateCellValue());
						st.setIssuedconduct(row.getCell(38)
								.getStringCellValue());
						st.setStatus(row.getCell(39).getStringCellValue());

						result.setStatus("success");
					} catch (Exception e) {
						System.out.println(i + " " + e.getMessage());
						status = false;
						result.setStatus("fail");
					}
					st.setOrgId(user.getOrgId());
					st.setAcademicyear(studentbean.getAcademicyear());
					result.setStudent(st);
					results.add(result);
					studentbean.setUploadresults(results);
					studentbean.setUploadstatus(status);

				}
			}

		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	
	@Override
	public void saveUploadedData(List<StudentResult> uploadresults) {
		List<Student> students = new ArrayList<Student>();
		for (StudentResult result : uploadresults) {
			students.add(result.getStudent());
		}

		studentDao.saveUploadedStudents(students);
	}

	@Override
	public String downloadStudents(StudentBean studentbean,User user) {
		
		List<Student> students= studentDao.getSearchResults(studentbean, user);
		try {
			FileOutputStream fileOut = new FileOutputStream("D:\\images\\"+studentbean.getAcademicyear()+"_Students.xls");
			HSSFWorkbook workbook = new HSSFWorkbook();
			HSSFSheet worksheet = workbook.createSheet("Students");

			// index from 0,0... cell A1 is cell(0,0)
			HSSFRow row1 = worksheet.createRow(0);

			HSSFCell aa = row1.createCell(0);
			aa.setCellValue("Admission Number");
			
			HSSFCell bb = row1.createCell(1);
			bb.setCellValue("DOJ");
			
			HSSFCell cc = row1.createCell(2);
			cc.setCellValue("Class");

			HSSFCell dd = row1.createCell(3);
			dd.setCellValue("Section");
			
			HSSFCell ee = row1.createCell(4);
			ee.setCellValue("Medium");
			
			HSSFCell cellF1 = row1.createCell(5);
			cellF1.setCellValue("Roll Number");
			
			HSSFCell cellG1 = row1.createCell(3);
			cellG1.setCellValue("First Name");
			
			HSSFCell cellH1 = row1.createCell(6);
			cellH1.setCellValue("Last Name");

			HSSFCell cellI1 = row1.createCell(7);
			cellI1.setCellValue("Gender");
			
			HSSFCell cellJ1 = row1.createCell(8);
			cellJ1.setCellValue("DOB");
			
			HSSFCell cellK1 = row1.createCell(9);
			cellK1.setCellValue("Religion");
			
			HSSFCell cellL1 = row1.createCell(10);
			cellL1.setCellValue("Caste");
			
			HSSFCell cellM1 = row1.createCell(11);
			cellM1.setCellValue("Caste Name");
			
			HSSFCell cellN1 = row1.createCell(12);
			cellN1.setCellValue("Parent Name");
			
			HSSFCell cellO1 = row1.createCell(13);
			cellO1.setCellValue("Mobile Number");
			
			HSSFCell cellP1 = row1.createCell(14);
			cellP1.setCellValue("Email");
			
			HSSFCell Q1 = row1.createCell(15);
			Q1.setCellValue("Occupation");
			
			
			HSSFCell S1 = row1.createCell(16);
			S1.setCellValue("Present Address");
			
			HSSFCell T1 = row1.createCell(17);
			T1.setCellValue("Permanent Address");
			
			HSSFCell R1 = row1.createCell(18);
			R1.setCellValue("Status");
			
			int i=1;
			SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
			
			for(Student student:students){
				HSSFRow row = worksheet.createRow(i);
				HSSFCell a = row.createCell(0);
				a.setCellValue(student.getAdmissionNo());
				
				HSSFCell b = row.createCell(1);
				b.setCellValue(student.getJoinedDate());
				if(student.getJoinedDate()!=null){
					b.setCellValue(format.format(student.getJoinedDate()));
				}
				
				
				HSSFCell c = row.createCell(2);
				c.setCellValue(student.getStclass());

				HSSFCell d = row.createCell(3);
				d.setCellValue(student.getSection());
				
				HSSFCell e = row.createCell(4);
				e.setCellValue(student.getMedium());
				
				HSSFCell f = row.createCell(5);
				f.setCellValue(student.getRollNo());
				
				HSSFCell g = row.createCell(3);
				g.setCellValue(student.getFirstname());
				
				HSSFCell h = row.createCell(6);
				h.setCellValue(student.getLastname());

				HSSFCell i1 = row.createCell(7);
				i1.setCellValue(student.getGender());
				
				HSSFCell j = row.createCell(8);
				j.setCellValue(student.getBirthDate());
				if(student.getBirthDate()!=null){
					j.setCellValue(format.format(student.getBirthDate()));
				}
				
				HSSFCell k = row.createCell(9);
				k.setCellValue(student.getReligion());
				
				HSSFCell l = row.createCell(10);
				l.setCellValue(student.getCaste());
				
				HSSFCell m = row.createCell(11);
				m.setCellValue(student.getCastename());
				
				HSSFCell n = row.createCell(12);
				n.setCellValue(student.getParentName());
				
				HSSFCell o = row.createCell(13);
				o.setCellValue(student.getMobile());
				
				HSSFCell p = row.createCell(14);
				p.setCellValue(student.getEmail());
				
				HSSFCell q = row.createCell(15);
				q.setCellValue(student.getOccupation());
				
				
				HSSFCell s = row.createCell(16);
				s.setCellValue(student.getPresentAddress());
				
				HSSFCell t = row.createCell(17);
				t.setCellValue(student.getPremanentAddress());
				HSSFCell r = row.createCell(18);
				r.setCellValue(student.getStatus());
				i++;
				
			}
			workbook.write(fileOut);
			fileOut.flush();
			
			fileOut.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return "D:\\images\\"+studentbean.getAcademicyear()+"_Students.xls";
	}
	
	@Override
	public String getDocumentPath(Long documentid) {

		Document photo = studentDao.getDocumentContent(documentid, "PHOTO");
		OutputStream outputStream = null;
		if (photo == null) {
			return null;
		}
		try {
			outputStream = new FileOutputStream("E:\\images\\"
					+ photo.getFilename());
			outputStream.write(photo.getContent());
			outputStream.close();
			return "E:\\images\\" + photo.getFilename();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	private String getPhotoPath(StudentBean studentbean) {
		try {
			MultipartFile filea = studentbean.getFiledata();
			InputStream inputStream = null;
			OutputStream outputStream = null;
			if (filea.getSize() > 0) {
				inputStream = filea.getInputStream();
				outputStream = new FileOutputStream("D:\\images\\"
						+ filea.getOriginalFilename());
				int readBytes = 0;
				byte[] buffer = new byte[30000];
				while ((readBytes = inputStream.read(buffer, 0, 30000)) != -1) {
					outputStream.write(buffer, 0, readBytes);
				}
				outputStream.close();
				inputStream.close();
				/*
				 * session.setAttribute("uploadFile", "C:\\test111\\" +
				 * filea.getOriginalFilename());
				 */
				return "D:\\images\\" + filea.getOriginalFilename();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public List<YearBean> getCourseYears(String stclass,User user) {
		List<YearBean> years = new ArrayList<>();
		for(int i=1;i<= studentDao.getCourseYears(stclass,user.getOrgId());i++)
			years.add(new YearBean(i, i));
		return years;
	}
	
	@Override
	public List<OrganizationMedium> getMediums(User user) {
		
		return studentDao.getMediums(user.getOrgId());
	}
}
