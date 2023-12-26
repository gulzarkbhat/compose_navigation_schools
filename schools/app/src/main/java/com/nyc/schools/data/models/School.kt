package com.nyc.schools.data.models


import com.google.gson.annotations.SerializedName

data class School(
    @SerializedName("academicopportunities1")
    var academicopportunities1: String,
    @SerializedName("academicopportunities2")
    var academicopportunities2: String,
    @SerializedName("admissionspriority11")
    var admissionspriority11: String,
    @SerializedName("admissionspriority21")
    var admissionspriority21: String,
    @SerializedName("admissionspriority31")
    var admissionspriority31: String,
    @SerializedName("attendance_rate")
    var attendanceRate: String,
    @SerializedName("bbl")
    var bbl: String,
    @SerializedName("bin")
    var bin: String,
    @SerializedName("boro")
    var boro: String,
    @SerializedName("borough")
    var borough: String,
    @SerializedName("building_code")
    var buildingCode: String,
    @SerializedName("bus")
    var bus: String,
    @SerializedName("census_tract")
    var censusTract: String,
    @SerializedName("city")
    var city: String,
    @SerializedName("code1")
    var code1: String,
    @SerializedName("community_board")
    var communityBoard: String,
    @SerializedName("council_district")
    var councilDistrict: String,
    @SerializedName("dbn")
    var dbn: String,
    @SerializedName("directions1")
    var directions1: String,
    @SerializedName("ell_programs")
    var ellPrograms: String,
    @SerializedName("extracurricular_activities")
    var extracurricularActivities: String,
    @SerializedName("fax_number")
    var faxNumber: String,
    @SerializedName("finalgrades")
    var finalgrades: String,
    @SerializedName("grade9geapplicants1")
    var grade9geapplicants1: String,
    @SerializedName("grade9geapplicantsperseat1")
    var grade9geapplicantsperseat1: String,
    @SerializedName("grade9gefilledflag1")
    var grade9gefilledflag1: String,
    @SerializedName("grade9swdapplicants1")
    var grade9swdapplicants1: String,
    @SerializedName("grade9swdapplicantsperseat1")
    var grade9swdapplicantsperseat1: String,
    @SerializedName("grade9swdfilledflag1")
    var grade9swdfilledflag1: String,
    @SerializedName("grades2018")
    var grades2018: String,
    @SerializedName("interest1")
    var interest1: String,
    @SerializedName("latitude")
    var latitude: String,
    @SerializedName("location")
    var location: String,
    @SerializedName("longitude")
    var longitude: String,
    @SerializedName("method1")
    var method1: String,
    @SerializedName("neighborhood")
    var neighborhood: String,
    @SerializedName("nta")
    var nta: String,
    @SerializedName("offer_rate1")
    var offerRate1: String,
    @SerializedName("overview_paragraph")
    var overviewParagraph: String,
    @SerializedName("pct_stu_enough_variety")
    var pctStuEnoughVariety: String,
    @SerializedName("pct_stu_safe")
    var pctStuSafe: String,
    @SerializedName("phone_number")
    var phoneNumber: String,
    @SerializedName("primary_address_line_1")
    var primaryAddressLine1: String,
    @SerializedName("program1")
    var program1: String,
    @SerializedName("requirement1_1")
    var requirement11: String,
    @SerializedName("requirement2_1")
    var requirement21: String,
    @SerializedName("requirement3_1")
    var requirement31: String,
    @SerializedName("requirement4_1")
    var requirement41: String,
    @SerializedName("requirement5_1")
    var requirement51: String,
    @SerializedName("school_10th_seats")
    var school10thSeats: String,
    @SerializedName("school_accessibility_description")
    var schoolAccessibilityDescription: String,
    @SerializedName("school_email")
    var schoolEmail: String,
    @SerializedName("school_name")
    var schoolName: String,
    @SerializedName("school_sports")
    var schoolSports: String,
    @SerializedName("seats101")
    var seats101: String,
    @SerializedName("seats9ge1")
    var seats9ge1: String,
    @SerializedName("seats9swd1")
    var seats9swd1: String,
    @SerializedName("state_code")
    var stateCode: String,
    @SerializedName("subway")
    var subway: String,
    @SerializedName("total_students")
    var totalStudents: String,
    @SerializedName("website")
    var website: String,
    @SerializedName("zip")
    var zip: String
)