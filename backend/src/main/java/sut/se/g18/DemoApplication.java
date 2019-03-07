package sut.se.g18;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import sut.se.g18.Entity.*;
import sut.se.g18.Repository.*;

import java.text.SimpleDateFormat;
import java.util.stream.Stream;

@SpringBootApplication
public class DemoApplication {

	private SimpleDateFormat formatter5 = new SimpleDateFormat("E, MMM dd yyyy HH:mm:ss");

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	ApplicationRunner init(ContractRepository contractRepository, CompanyRepository companyRepository,
			MaidSelectRepository maidSelectRepository, PromotionRepository promotionRepository,
			CustomerRepository customerRepository, AdminAccountRepository adminAccountRepository,
			ContractTypeRepository contractTypeRepository, PaymentStatusRepository paymentStatusRepository,
			MaidStatusRepository maidStatusRepository, MaidRegisterRepository maidRegisterRepository,
			TitleNameRepository titleNameRepository, TypeworkingRepository typeworkingRepository,
			WorkingDateRepositoy workingDateRepositoy, CountryCodeRepository countryCodeRepository,
			SexRepository sexRepository, TypepaymentRepository typepaymentRepository, BankRepository bankRepository,
			CleaningEquipmentRepository cleaningEquipmentRepository,
			
			
			PromotionTypeRepository promotionTypeRepository, SkillRepository skillRepository,
			CourseTypeRepository courseTypeRepository, CourseRepository courseRepository,
			CompanyTypeRepository companyTypeRepository, ProvinceRepository provinceRepository,
			ComplaintTypeRepository complaintTypeRepository,TypewelfareRepository typewelfareRepository,
			ScoreRepository scoreRepository, WelfareAndSalaryRepository welfareAndSalaryRepository,
			TypeReviewRepository typeReviewRepository) {
		return args -> {

			// Insert Company Type
			CompanyTypeEntity PublicCompany = new CompanyTypeEntity("บริษัทมหาชน");
			companyTypeRepository.save(PublicCompany);
			CompanyTypeEntity PrivateCompanies = new CompanyTypeEntity("บริษัทเอกชน");
			companyTypeRepository.save(PrivateCompanies);

			// insert Province
			Stream.of("กรุงเทพมหานคร", "กระบี่", "กาญจนบุรี", "กาฬสินธุ์", "กำแพงเพชร", "ขอนแก่น", "จันทบุรี",
					"ฉะเชิงเทรา", "ชลบุรี", "ชัยนาท", "ชัยภูมิ", "ชุมพร", "เชียงราย", "เชียงใหม่", "ตรัง", "ตราด",
					"ตาก", "นครนายก", "นครปฐม", "นครพนม", "นครราชสีมา", "นครศรีธรรมราช", "นครสวรรค์", "นนทบุรี",
					"นราธิวาส", "น่าน", "บึงกาฬ", "บุรีรัมย์", "ปทุมธานี", "ประจวบคีรีขันธ์", "ปราจีนบุรี", "ปัตตานี",
					"พระนครศรีอยุธยา", "พังงา", "พัทลุง", "พิจิตร", "พิษณุโลก", "เพชรบุรี", "เพชรบูรณ์", "แพร่",
					"พะเยา", "ภูเก็ต", "มหาสารคาม", "มุกดาหาร", "แม่ฮ่องสอน", "ยะลา", "ยโสธร", "ร้อยเอ็ด", "ระนอง",
					"ระยอง", "ราชบุรี", "ลพบุรี", "ลำปาง", "ลำพูน", "เลย", "ศรีสะเกษ", "สกลนคร", "สงขลา", "สตูล",
					"สมุทรปราการ", "สมุทรสงคราม", "สมุทรสาคร", "สระแก้ว", "สระบุรี", "สิงห์บุรี", "สุโขทัย",
					"สุพรรณบุรี", "สุราษฎร์ธานี", "สุรินทร์", "หนองคาย", "หนองบัวลำภู", "อ่างทอง", "อุดรธานี",
					"อุทัยธานี", "อุตรดิตถ์", "อุบลราชธานี", "อำนาจเจริญ").forEach(provinces -> {
						ProvinceEntity province = new ProvinceEntity();
						province.setProvinceName(provinces);
						provinceRepository.save(province);
					});

			SkillEntity sk1 = new SkillEntity();
			sk1.setSkillRank("Beginner");
			skillRepository.save(sk1);
			SkillEntity sk2 = new SkillEntity();
			sk2.setSkillRank("Apprentice");
			skillRepository.save(sk2);
			SkillEntity sk3 = new SkillEntity();
			sk3.setSkillRank("Professional");
			skillRepository.save(sk3);
			SkillEntity sk4 = new SkillEntity();
			sk4.setSkillRank("Master");
			skillRepository.save(sk4);
			SkillEntity sk5 = new SkillEntity();
			sk5.setSkillRank("Guru");
			skillRepository.save(sk5);

			CourseTypeEntity ct1 = new CourseTypeEntity();
			ct1.setCourseType("ดูแลบ้าน");
			courseTypeRepository.save(ct1);
			CourseTypeEntity ct2 = new CourseTypeEntity();
			ct2.setCourseType("งานในครัว");
			courseTypeRepository.save(ct2);
			CourseTypeEntity ct3 = new CourseTypeEntity();
			ct3.setCourseType("ดูแลสวน");
			courseTypeRepository.save(ct3);
			// Insert Country_code
			// NORTH AMERICA
			CountryCodeEntity Alaska = new CountryCodeEntity("+1+907 (อะเเลสกา)");
			countryCodeRepository.save(Alaska);
			CountryCodeEntity Canada = new CountryCodeEntity("+1 (แคนาดา)");
			countryCodeRepository.save(Canada);
			CountryCodeEntity Hawaii = new CountryCodeEntity("+1+808 (ฮาวาย)");
			countryCodeRepository.save(Hawaii);
			CountryCodeEntity USA = new CountryCodeEntity("+1 (สหรัฐอเมริกา)");
			countryCodeRepository.save(USA);
			// ASIA
			CountryCodeEntity Bangladesh = new CountryCodeEntity("+880 (บังคลาเทศ)");
			countryCodeRepository.save(Bangladesh);
			CountryCodeEntity Bhutan = new CountryCodeEntity("+975 (ภูฏาน)");
			countryCodeRepository.save(Bhutan);
			CountryCodeEntity Brunei = new CountryCodeEntity("+673 (บรูไน)");
			countryCodeRepository.save(Brunei);
			CountryCodeEntity Cambodia = new CountryCodeEntity("+855 (กัมพูชา)");
			countryCodeRepository.save(Cambodia);
			CountryCodeEntity China = new CountryCodeEntity("+86 (จีน)");
			countryCodeRepository.save(China);
			CountryCodeEntity Laos = new CountryCodeEntity("+856 (ลาว)");
			countryCodeRepository.save(Laos);
			CountryCodeEntity Malaysia = new CountryCodeEntity("+856 (มาเลเซีย)");
			countryCodeRepository.save(Malaysia);
			CountryCodeEntity Hongkong = new CountryCodeEntity("+852 (ฮ่องกง)");
			countryCodeRepository.save(Hongkong);
			CountryCodeEntity India = new CountryCodeEntity("+91 (อินเดีย)");
			countryCodeRepository.save(India);
			CountryCodeEntity Indonesia = new CountryCodeEntity("+62 (อินโดนีเซีย)");
			countryCodeRepository.save(Indonesia);
			CountryCodeEntity Japan = new CountryCodeEntity("+81 (ญี่ปุ่น)");
			countryCodeRepository.save(Japan);
			CountryCodeEntity Koreasouth = new CountryCodeEntity("+82 (เกาหลีใต้)");
			countryCodeRepository.save(Koreasouth);
			CountryCodeEntity Macao = new CountryCodeEntity("+853 (มาเก๊า)");
			countryCodeRepository.save(Macao);
			CountryCodeEntity Maldives = new CountryCodeEntity("+960 (มัลดีฟส์)");
			countryCodeRepository.save(Maldives);
			CountryCodeEntity Mongolia = new CountryCodeEntity("+976 (มองโกเลีย)");
			countryCodeRepository.save(Mongolia);
			CountryCodeEntity Myanmar = new CountryCodeEntity("+95 (พม่า)");
			countryCodeRepository.save(Myanmar);
			CountryCodeEntity Nepal = new CountryCodeEntity("+977 (เนปาล)");
			countryCodeRepository.save(Nepal);
			CountryCodeEntity Pakistan = new CountryCodeEntity("+92 (ปากีสถาน)");
			countryCodeRepository.save(Pakistan);
			CountryCodeEntity Philippines = new CountryCodeEntity("+63 (ฟิลิปปินส์)");
			countryCodeRepository.save(Philippines);
			CountryCodeEntity Singapore = new CountryCodeEntity("+65 (สิงคโปร์)");
			countryCodeRepository.save(Singapore);
			CountryCodeEntity Srilanka = new CountryCodeEntity("+94 (ศรีลังกา)");
			countryCodeRepository.save(Srilanka);
			CountryCodeEntity Thailand = new CountryCodeEntity("+66 (ไทย)");
			countryCodeRepository.save(Thailand);
			CountryCodeEntity Taiwan = new CountryCodeEntity("+886 (ไต้หวัน)");
			countryCodeRepository.save(Taiwan);
			CountryCodeEntity Vietnam = new CountryCodeEntity("+84 (เวียดนาม)");
			countryCodeRepository.save(Vietnam);

			// Australia, New Zealand
			CountryCodeEntity Australia = new CountryCodeEntity("+61 (ออสเตรเลีย)");
			countryCodeRepository.save(Australia);
			CountryCodeEntity Newzealand = new CountryCodeEntity("+64 (นิวซีแลนด์)");
			countryCodeRepository.save(Newzealand);
			// PACIFIC OCEAN
			CountryCodeEntity AmericanSamoa = new CountryCodeEntity("+684 (อเมริกันซามัว)");
			countryCodeRepository.save(AmericanSamoa);
			CountryCodeEntity Fiji = new CountryCodeEntity("+679 (ฟีจี)");
			countryCodeRepository.save(Fiji);
			CountryCodeEntity Frenchpolynesia = new CountryCodeEntity("+689 (เฟรนช์พอลินีเชีย)");
			countryCodeRepository.save(Frenchpolynesia);
			CountryCodeEntity Guam = new CountryCodeEntity("+1+671 (กวม)");
			countryCodeRepository.save(Guam);
			CountryCodeEntity Micronesia = new CountryCodeEntity("+691 (ไมโครนีเซีย)");
			countryCodeRepository.save(Micronesia);
			CountryCodeEntity Nauru = new CountryCodeEntity("+674 (นาอูรู)");
			countryCodeRepository.save(Nauru);
			CountryCodeEntity Newcaledonia = new CountryCodeEntity("+687 (นิวแคลิโดเนีย)");
			countryCodeRepository.save(Newcaledonia);
			CountryCodeEntity Papuanewguinea = new CountryCodeEntity("+675 (ปาปัวนิวกินี)");
			countryCodeRepository.save(Papuanewguinea);
			CountryCodeEntity Saipan = new CountryCodeEntity("+1+670 (เกาะไซปัน)");
			countryCodeRepository.save(Saipan);
			CountryCodeEntity Tokelau = new CountryCodeEntity("+690 (โทเคอเลา)");
			countryCodeRepository.save(Tokelau);
			// insert promotionType

			PromotionTypeEntity promotionTypeEntity = new PromotionTypeEntity();
			promotionTypeEntity.setPromotionType("ส่วนลด");
			promotionTypeRepository.save(promotionTypeEntity);
			

			
			//insert ComplaintType
			ComplaintTypeEntity complaintTypeEntity = new ComplaintTypeEntity();
			complaintTypeEntity.setComplaintType("พฤติกรรมไม่เหมาะสม");
			complaintTypeRepository.save(complaintTypeEntity);
            
			ComplaintTypeEntity complaintTypeEntity2 = new ComplaintTypeEntity();
			complaintTypeEntity2.setComplaintType("ไม่ตรงต่อเวลา");
			complaintTypeRepository.save(complaintTypeEntity2);

			ComplaintTypeEntity complaintTypeEntity3 = new ComplaintTypeEntity();
			complaintTypeEntity3.setComplaintType("พูดจาไม่สุภาพ");
			complaintTypeRepository.save(complaintTypeEntity3);

			// Insert Sex
			SexEntity m = new SexEntity("ชาย");
			sexRepository.save(m);
			SexEntity fm = new SexEntity("หญิง");
			sexRepository.save(fm);
			SexEntity nfmm = new SexEntity("-ไม่ระบุ-");
			sexRepository.save(nfmm);

			Stream.of("นาง", "นางสาว", "นาย").forEach(title -> {

				if (title.equals("นาง")) {
					TitleNameEntity titleNameEntityEntity = new TitleNameEntity();
					titleNameEntityEntity.setTitlenameType("นาง");
					titleNameRepository.save(titleNameEntityEntity);
				}

				if (title.equals("นางสาว")) {
					TitleNameEntity titleNameEntityEntity = new TitleNameEntity();
					titleNameEntityEntity.setTitlenameType("นางสาว");
					titleNameRepository.save(titleNameEntityEntity);
				}

				if (title.equals("นาย")) {
					TitleNameEntity titleNameEntityEntity = new TitleNameEntity();
					titleNameEntityEntity.setTitlenameType("นาย");
					titleNameRepository.save(titleNameEntityEntity);
				}

			});

			Stream.of("แม่บ้าน", "แม่บ้านดูแลเด็ก", "แม่บ้านดูแลเผู้สูงอายุ", "คนดูแดสวน", "คนขับรถ")
					.forEach(typeworking -> {
						if (typeworking.equals("แม่บ้าน")) {
							TypeworkingEntity typeworkingEntityEntity = new TypeworkingEntity();
							typeworkingEntityEntity.setTypeworking("แม่บ้าน");
							typeworkingRepository.save(typeworkingEntityEntity);
						}
						if (typeworking.equals("แม่บ้านดูแลเด็ก")) {
							TypeworkingEntity typeworkingEntityEntity = new TypeworkingEntity();
							typeworkingEntityEntity.setTypeworking("แม่บ้านดูแลเด็ก");
							typeworkingRepository.save(typeworkingEntityEntity);
						}
						if (typeworking.equals("แม่บ้านดูแลเผู้สูงอายุ")) {
							TypeworkingEntity typeworkingEntityEntity = new TypeworkingEntity();
							typeworkingEntityEntity.setTypeworking("แม่บ้านดูแลผู้สูงอายุ");
							typeworkingRepository.save(typeworkingEntityEntity);
						}
						if (typeworking.equals("คนดูแดสวน")) {
							TypeworkingEntity typeworkingEntityEntity = new TypeworkingEntity();
							typeworkingEntityEntity.setTypeworking("คนดูแดสวน");
							typeworkingRepository.save(typeworkingEntityEntity);
						}
						if (typeworking.equals("คนขับรถ")) {
							TypeworkingEntity typeworkingEntityEntity = new TypeworkingEntity();
							typeworkingEntityEntity.setTypeworking("คนขับรถ");
							typeworkingRepository.save(typeworkingEntityEntity);
						}
					});

			Stream.of("ทำงานแบบรายวัน", "ทำงานแบบรายสัปดาห์", "ทำงานแบบรายเดือน", "ทำงานแบบรายปี")
					.forEach(workingDate -> {
						if (workingDate.equals("ทำงานแบบรายวัน")) {
							WorkingDateEntity workingDateEntityEntity = new WorkingDateEntity();
							workingDateEntityEntity.setTypeworkingDate("ทำงานแบบรายวัน");
							workingDateRepositoy.save(workingDateEntityEntity);
						}
						if (workingDate.equals("ทำงานแบบรายสัปดาห์")) {
							WorkingDateEntity workingDateEntityEntity = new WorkingDateEntity();
							workingDateEntityEntity.setTypeworkingDate("ทำงานแบบรายสัปดาห์");
							workingDateRepositoy.save(workingDateEntityEntity);
						}
						if (workingDate.equals("ทำงานแบบรายเดือน")) {
							WorkingDateEntity workingDateEntityEntity = new WorkingDateEntity();
							workingDateEntityEntity.setTypeworkingDate("ทำงานแบบรายเดือน");
							workingDateRepositoy.save(workingDateEntityEntity);
						}
						if (workingDate.equals("ทำงานแบบรายปี")) {
							WorkingDateEntity workingDateEntityEntity = new WorkingDateEntity();
							workingDateEntityEntity.setTypeworkingDate("ทำงานแบบรายปี");
							workingDateRepositoy.save(workingDateEntityEntity);
						}
					});
			Stream.of("ธนาคารไทยพานิชย์", "ธนาคารกรุงไทย", "ธนาคารกสิกรไทย", "ธนาคารออมสิน", "ธนาคารกรุงเทพ")
					.forEach(bankname -> {
						BankEntity bank = new BankEntity();
						bank.setBankname(bankname);
						bankRepository.save(bank);
					});

			Stream.of("Visa", "Paypal", "MasterCard", "Amex", "JBC").forEach(typepay -> {
				TypepaymentEntity type = new TypepaymentEntity();
				type.setTypename(typepay);
				typepaymentRepository.save(type);
			});
            //Add Typewelfare
            Stream.of("สวัสดิการเพื่อความมั่นคงและสุขภาพ","สวัสดิการที่จ่ายตอบแทนเมื่อไม่ได้ทำงาน","สวัสดิการบริการ").forEach(welfare -> {
                TypewelfareEntity type = new TypewelfareEntity();
                type.setTypewelName(welfare);
                typewelfareRepository.save(type);
            });
			AdminAccountEntity admin = new AdminAccountEntity();
			admin.setAdminUsername("1234");
			admin.setAdminPassword("4321");
			adminAccountRepository.save(admin);

			PaymentStatusEntity s1 = new PaymentStatusEntity();
			s1.setPaymentStatus("ค้างชำระ");
			paymentStatusRepository.save(s1);
			PaymentStatusEntity s2 = new PaymentStatusEntity();
			s2.setPaymentStatus("จ่ายแล้ว");
			paymentStatusRepository.save(s2);

			MaidStatusEntity stat2 = new MaidStatusEntity();
			stat2.setStatus("จอง");
			maidStatusRepository.save(stat2);
			MaidStatusEntity stat3 = new MaidStatusEntity();
			stat3.setStatus("ทำสัญญาอยู่");
			maidStatusRepository.save(stat3);

			ContractTypeEntity type1 = new ContractTypeEntity();
			type1.setContractType("1 Day");
			contractTypeRepository.save(type1);
			ContractTypeEntity type2 = new ContractTypeEntity();
			type2.setContractType("1 Week");
			contractTypeRepository.save(type2);
			ContractTypeEntity type3 = new ContractTypeEntity();
			type3.setContractType("1 Month");
			contractTypeRepository.save(type3);
			ContractTypeEntity type4 = new ContractTypeEntity();
			type4.setContractType("6 Months");
			contractTypeRepository.save(type4);
			ContractTypeEntity type5 = new ContractTypeEntity();
			type5.setContractType("1 Year");
			contractTypeRepository.save(type5);

			CustomerEntity cus = new CustomerEntity();
			cus.setCustomerName("Pitchayut CheeseJa");
			cus.setCustomerphone("0890000000");
			cus.setCustomerper("1430200231078");
			cus.setCustomerEmail("cheesecheese@gmail.com");
			cus.setCustomeraddress("222 หมู่ 8 มทส.");
			cus.setCustomerpass("111111");
			SexEntity sex = sexRepository.findBycustomersex("ชาย");
			cus.setSexEntity(sex);
			TitleNameEntity title = titleNameRepository.findBytitlenameType("นาย");
			cus.setTitle(title);
			CountryCodeEntity code = countryCodeRepository.findBycountrycode("+679 (ฟีจี)");
			cus.setCountry(code);
			customerRepository.save(cus);

		    CompanyEntity c1 = new CompanyEntity();
		    c1.setCompanyName("บริษัทพีกาซัส");
		    c1.setCompanyAddress("aa");
			c1.setCompanyPhone("011111111");
			CompanyTypeEntity ctt1 = companyTypeRepository.findBycompanyType("บริษัทมหาชน");
			c1.setCompanyTypeEntity(ctt1);
			ProvinceEntity p11 = provinceRepository.findByprovinceName("หนองคาย");
			c1.setProvinecEntity(p11);
			companyRepository.save(c1);
			CompanyEntity c2 = new CompanyEntity();
			c2.setCompanyName("บริษัทโอซาก้า");
			c2.setCompanyAddress("bb");
			c2.setCompanyPhone("022222222");
			CompanyTypeEntity ctt2 = companyTypeRepository.findBycompanyType("บริษัทเอกชน");
			c2.setCompanyTypeEntity(ctt2);
			ProvinceEntity p22 = provinceRepository.findByprovinceName("นครราชสีมา");
			c2.setProvinecEntity(p22);
			companyRepository.save(c2);

			CompanyEntity c3 = new CompanyEntity();
			c3.setCompanyName("บริษัทกินซ่า");
			c3.setCompanyAddress("cc");
			c3.setCompanyPhone("033333333");
			CompanyTypeEntity ctt3 = companyTypeRepository.findBycompanyType("บริษัทมหาชน");
			c3.setCompanyTypeEntity(ctt3);
			ProvinceEntity p33 = provinceRepository.findByprovinceName("ชลบุรี");
			c3.setProvinecEntity(p33);

			companyRepository.save(c3);

			CompanyEntity c4 = new CompanyEntity();
			c4.setCompanyName("บริษัทสวนรักษ์");
			c4.setCompanyAddress("dd");
			c4.setCompanyPhone("044444444");
			CompanyTypeEntity ct4 = companyTypeRepository.findBycompanyType("บริษัทเอกชน");
			c4.setCompanyTypeEntity(ct4);
			ProvinceEntity p44 = provinceRepository.findByprovinceName("เชียงใหม่");
			c4.setProvinecEntity(p44);
			companyRepository.save(c4);

			CourseEntity co1 = new CourseEntity();
			CompanyEntity comp1 = companyRepository.findBycompanyName("บริษัทพีกาซัส");
			CourseTypeEntity ctype1 = courseTypeRepository.findByCourseType("งานในครัว");
			co1.setCourseTitle("คอร์สฝึกสอนทำอาหารอีสาน");
			co1.setCourseDetail("ทำลาบ ก้อย");
			co1.setCompany(comp1);
			co1.setCourseType(ctype1);
			courseRepository.save(co1);
			CourseEntity co2 = new CourseEntity();
			CourseTypeEntity ctype2 = courseTypeRepository.findByCourseType("ดูแลสวน");
			co2.setCourseTitle("คอร์สอบรมการตกแต่งกิ่งต้นบอนไซ");
			co2.setCourseDetail("เรียนรู้การตัดแต่งกิ่งต้นบอนไซเบื้องต้น");
			co2.setCompany(comp1);
			co2.setCourseType(ctype2);
			courseRepository.save(co2);

			MaidRegisterEntity mm1 = new MaidRegisterEntity();
			CompanyEntity com = companyRepository.findBycompanyName("บริษัทพีกาซัส");
			CompanyEntity com2 = companyRepository.findBycompanyName("บริษัทโอซาก้า");
			CompanyEntity com3 = companyRepository.findBycompanyName("บริษัทกินซ่า");
			CompanyEntity com4 = companyRepository.findBycompanyName("บริษัทสวนรักษ์");

			TypeworkingEntity type00 = typeworkingRepository.findByTypeworking("แม่บ้าน");
			TypeworkingEntity type11 = typeworkingRepository.findByTypeworking("แม่บ้านดูแลเด็ก");
			TypeworkingEntity type22 = typeworkingRepository.findByTypeworking("แม่บ้านดูแลผู้สูงอายุ");
			TypeworkingEntity type33 = typeworkingRepository.findByTypeworking("คนทำสวน");
			TypeworkingEntity type44 = typeworkingRepository.findByTypeworking("คนขับรถ");

			WorkingDateEntity work00 = workingDateRepositoy.findBytypeworkingDate("ทำงานแบบรายวัน");
			WorkingDateEntity work11 = workingDateRepositoy.findBytypeworkingDate("ทำงานแบบรายเดือน");
			WorkingDateEntity work22 = workingDateRepositoy.findBytypeworkingDate("ทำงานแบบรายปี");

			TitleNameEntity title00 = titleNameRepository.findBytitlenameType("นาย");
			TypewelfareEntity typewel00 = typewelfareRepository.findByTypewelName("สวัสดิการเพื่อความมั่นคงและสุขภาพ");

			WelfareAndSalaryEntity wel0 = new WelfareAndSalaryEntity();
			wel0.setCompany(com);
			wel0.setTypewelfare(typewel00);
			wel0.setWorkingdate(work00);
			wel0.setWelsaName("ตรวจสุขภาพประจำปีฟรีครับ");
			wel0.setSalary(1500);
			wel0.setDatail("ได้รับการตรวจสุขภาพประจำปีฟรีทุกปีครับ");
			wel0.setTermCon("ตรวจสุขภาพได้ปีละไม่เกิน2ครั้งครับ");
			welfareAndSalaryRepository.save(wel0);

			mm1.setCompanyForMaid(com);
			mm1.setMaidName("Ping Kasinan");
			mm1.setMaidPhone("0935395533");
            mm1.setMaidAddress("หมู 6");
            mm1.setProvince("กาญนะจ๊ก");
            mm1.setDistrict("ดอนชะเอม");
			mm1.setCanton("เมือง");
			mm1.setMaidEmail("se01@gmail.com");
			mm1.setWorkingDateEntity(work00);
			mm1.setTypeworkingEntity(type00);
			mm1.setTitleNameEntity(title00);
			mm1.setWelfareAndSalaryEntity(wel0);
			maidRegisterRepository.save(mm1);

			MaidRegisterEntity mm2 = new MaidRegisterEntity();
			mm2.setMaidName("Ball Donlawat");
			mm2.setMaidPhone("0935395544");
			mm2.setCompanyForMaid(com2);
            mm2.setMaidAddress("หมู 7");
            mm2.setProvince("กาญนะจ๊ก");
            mm2.setDistrict("ดอนชะเอม");
			mm2.setCanton("เมือง");
			mm2.setMaidEmail("se02@gmail.com");
			mm2.setWorkingDateEntity(work11);
			mm2.setTypeworkingEntity(type11);
			mm2.setWelfareAndSalaryEntity(wel0);
			mm2.setTitleNameEntity(title00);

			maidRegisterRepository.save(mm2);
			MaidRegisterEntity mm3 = new MaidRegisterEntity();
			mm3.setMaidName("Yongyut Srisuban");
			mm3.setMaidPhone("0935395555");
			mm3.setCompanyForMaid(com);
            mm3.setMaidAddress("หมู 8");
            mm3.setProvince("กาญนะจ๊ก");
            mm3.setDistrict("ดอนชะเอม");
			mm3.setCanton("เมือง");
			mm3.setMaidEmail("se03@gmail.com");
			mm3.setWorkingDateEntity(work22);
			mm3.setTypeworkingEntity(type22);
			mm3.setTitleNameEntity(title00);
			mm3.setWelfareAndSalaryEntity(wel0);
			maidRegisterRepository.save(mm3);
			MaidRegisterEntity mm4 = new MaidRegisterEntity();
			mm4.setMaidName("Nanthika Poonpin");
			mm4.setMaidPhone("0935395566");
			mm4.setCompanyForMaid(com3);
            mm4.setMaidAddress("หมู 6");
            mm4.setProvince("กาญนะจ๊ก");
            mm4.setDistrict("ดอนชะเอม");
			mm4.setCanton("เมือง");
			mm4.setMaidEmail("se04@gmail.com");
			mm4.setWorkingDateEntity(work22);
			mm4.setTypeworkingEntity(type22);
			mm4.setTitleNameEntity(title00);
			mm4.setWelfareAndSalaryEntity(wel0);
			maidRegisterRepository.save(mm4);
			MaidRegisterEntity mm5 = new MaidRegisterEntity();
			mm5.setMaidName("Ploy Sumitra");
			mm5.setMaidPhone("0935395577");
			mm5.setCompanyForMaid(com4);
            mm5.setMaidAddress("หมู 6");
            mm5.setProvince("กาญนะจ๊ก");
            mm5.setDistrict("ดอนชะเอม");
			mm5.setCanton("เมือง");
			mm5.setMaidEmail("se05@gmail.com");
			mm5.setWorkingDateEntity(work00);
			mm5.setTypeworkingEntity(type44);
			mm5.setTitleNameEntity(title00);
			mm5.setWelfareAndSalaryEntity(wel0);
			maidRegisterRepository.save(mm5);

			
			MaidSelectEntity m1 = new MaidSelectEntity();
			CustomerEntity customer = customerRepository.findBycustomerName("Pitchayut CheeseJa");
			m1.setCustomer(customer);
			MaidRegisterEntity maid1 = maidRegisterRepository.findBymaidName("Ping Kasinan");
			m1.setMaid(maid1);
			MaidStatusEntity statusMaid = maidStatusRepository.findBystatus("จอง");
			m1.setStatus(statusMaid);
			m1.setWorkingday("เสาร์-อาทิตย์");
			m1.setMainjob("กวาดบ้าน");
			m1.setSecondaryjob("ล้างจาน");
			m1.setPlace("เรียนรวม");
			m1.setDatepick(formatter5.parse("Thu, Oct 18 2019 00:00:00"));
			maidSelectRepository.save(m1);

			MaidSelectEntity m3 = new MaidSelectEntity();
			m3.setCustomer(customer);
			MaidRegisterEntity maid2 = maidRegisterRepository.findBymaidName("Ball Donlawat");
			m3.setMaid(maid2);
			m3.setStatus(statusMaid);
			m3.setWorkingday("เสาร์-อาทิตย์");
			m3.setMainjob("กวาดบ้าน");
			m3.setSecondaryjob("ล้างจาน");
			m3.setDatepick(formatter5.parse("Thu, Oct 18 2019 00:00:00"));
			m3.setPlace("เรียนรวม");
			maidSelectRepository.save(m3);

			MaidSelectEntity m2 = new MaidSelectEntity();
			m2.setCustomer(customer);
			MaidRegisterEntity maid3 = maidRegisterRepository.findBymaidName("Yongyut Srisuban");
			m2.setMaid(maid3);
			m2.setStatus(statusMaid);
			m2.setWorkingday("เสาร์-อาทิตย์");
			m2.setMainjob("กวาดบ้าน");
			m2.setSecondaryjob("ล้างจาน");
			m2.setPlace("เรียนรวม");
			m2.setDatepick(formatter5.parse("Thu, Oct 18 2019 00:00:00"));
			maidSelectRepository.save(m2);

			MaidSelectEntity m4 = new MaidSelectEntity();
			m4.setCustomer(customer);
			MaidRegisterEntity maid4 = maidRegisterRepository.findBymaidName("Nanthika Poonpin");
			m4.setMaid(maid4);
			m4.setStatus(statusMaid);
			m4.setWorkingday("เสาร์-อาทิตย์");
			m4.setMainjob("กวาดบ้าน");
			m4.setSecondaryjob("ล้างจาน");
			m4.setPlace("เรียนรวม");
			m4.setDatepick(formatter5.parse("Thu, Oct 18 2019 00:00:00"));
			maidSelectRepository.save(m4);

			MaidSelectEntity m5 = new MaidSelectEntity();
			m5.setCustomer(customer);
			MaidRegisterEntity maid5 = maidRegisterRepository.findBymaidName("Ploy Sumitra");
			m5.setMaid(maid5);
			m5.setStatus(statusMaid);
			m5.setWorkingday("เสาร์-อาทิตย์");
			m5.setMainjob("กวาดบ้าน");
			m5.setSecondaryjob("ล้างจาน");
			m5.setPlace("เรียนรวม");
			m5.setDatepick(formatter5.parse("Thu, Oct 18 2019 00:00:00"));
			maidSelectRepository.save(m5);

			PromotionEntity p1 = new PromotionEntity();
            p1.setTitle("โปรโมชั่นลดราคา");
            p1.setDateStart(formatter5.parse("Thu, Oct 18 2019 00:00:00"));
            p1.setDateEnd(formatter5.parse("Thu, Oct 18 2019 00:00:00"));
            CompanyEntity company = companyRepository.findBycompanyName("บริษัทพีกาซัส");
            p1.setDiscount(15);
            p1.setCompanyEntity(company);
            promotionRepository.save(p1);

			 // Create CleaningEquipment
			Stream.of("ไม้กวาดดอกหญ้า ไม้ถูพื้น ถังน้ำ ไม้ปัดขนไก่",
					"ไม่กวาดทางมะพร้ว พรั่วตักขยะ ไม้กวาดหยักไย่ ผ้าเช็ดพื้น").forEach(cleaning -> {
						CleaningEquipmentEntity c = new CleaningEquipmentEntity(cleaning);
						c.setCleaning(cleaning);
						cleaningEquipmentRepository.save(c);
					});

			
			

			Stream.of("1","2","3","4","5").forEach(score -> {
				ScoreEntity sc = new ScoreEntity(score);
				sc.setScore(score);
				scoreRepository.save(sc);
			});
			
			TypewelfareEntity typewel = typewelfareRepository.findByTypewelName("สวัสดิการเพื่อความมั่นคงและสุขภาพ");
			TypewelfareEntity typewel1 = typewelfareRepository.findByTypewelName("สวัสดิการที่จ่ายตอบแทนเมื่อไม่ได้ทำงาน");
			TypewelfareEntity typewel2 = typewelfareRepository.findByTypewelName("สวัสดิการบริการ");

			CompanyEntity compa = companyRepository.findBycompanyName("บริษัทพีกาซัส");
			CompanyEntity compa1 = companyRepository.findBycompanyName("บริษัทโอซาก้า");
			CompanyEntity compa2 = companyRepository.findBycompanyName("บริษัทกินซ่า");

			WorkingDateEntity work = workingDateRepositoy.findBytypeworkingDate("ทำงานแบบรายวัน");
			WorkingDateEntity work1 = workingDateRepositoy.findBytypeworkingDate("ทำงานแบบรายเดือน");
			WorkingDateEntity work2 = workingDateRepositoy.findBytypeworkingDate("ทำงานแบบรายปี");

			WelfareAndSalaryEntity wel = new WelfareAndSalaryEntity();
			wel.setCompany(compa);
			wel.setTypewelfare(typewel);
			wel.setWorkingdate(work);
			wel.setWelsaName("ตรวจสุขภาพประจำปีฟรี");
			wel.setSalary(1500);
			wel.setDatail("ได้รับการตรวจสุขภาพประจำปีฟรีทุกปี");
			wel.setTermCon("ตรวจสุขภาพได้ปีละไม่เกิน2ครั้ง");
			welfareAndSalaryRepository.save(wel);

			WelfareAndSalaryEntity wel1 = new WelfareAndSalaryEntity();
			wel1.setCompany(compa1);
			wel1.setTypewelfare(typewel1);
			wel1.setWorkingdate(work1);
			wel1.setWelsaName("สวัสดิการบำเหน็ดบำนาญ");
			wel1.setSalary(3500);
			wel1.setDatail("ได้รับเงินบำเหบ็ดบำนาญหลังจากที่เกษียณอายุการทำงานแล้ว");
			wel1.setTermCon("ต้องมีอายุไม่ต่ำกว่า60ปี");
			welfareAndSalaryRepository.save(wel1);

			WelfareAndSalaryEntity wel2 = new WelfareAndSalaryEntity();
			wel2.setCompany(compa2);
			wel2.setTypewelfare(typewel2);
			wel2.setWorkingdate(work2);
			wel2.setWelsaName("นั่งรถเมย์ไปทำงานฟรี");
			wel2.setSalary(4500);
			wel2.setDatail("ได้นั่งรถเมย์ฟรีไปทำงานทุกวัน");
			wel2.setTermCon("นั่งได้เฉพาะรถเมย์ที่ปรับอากาศเท่านั้น");
			welfareAndSalaryRepository.save(wel2);

			WelfareAndSalaryEntity wel3 = new WelfareAndSalaryEntity();
			wel3.setCompany(compa1);
			wel3.setTypewelfare(typewel2);
			wel3.setWorkingdate(work2);
			wel3.setWelsaName("มีรถรับส่งไปทำงานทุกวัน");
			wel3.setSalary(6500);
			wel3.setDatail("มีรถรับส่งไปกลับจากที่พักถึงที่ทำงานทุกวัน");
			wel3.setTermCon("ต้องมารอรถก่อนเวลา7โมงเช้า");
			welfareAndSalaryRepository.save(wel3);

			Stream.of("การทำงาน","ความตรงต่อเวลา").forEach(typereview -> {
				TypeReviewEntity ty = new TypeReviewEntity(typereview);
				ty.setTypereview(typereview);
				typeReviewRepository.save(ty);
			});
		};
	}
}
