import json
import logging
from datetime import date
from typing import List
from uuid import uuid4

<Redacted>
<Redacted>


RISK_PROBABILITY_SYSTEM = "http://terminology.hl7.org/CodeSystem/risk-probability"

log = logging.getLogger(__name__)


#The dictionary that the states(keys) and their corresponding likelihood precentages(values) are stored
state_likelihoods = {}
my_state_likelihood = {}

def get_insights(request: HealthAppRequest) -> HealthAppResponse:
    state_likelihoods.clear()
    my_state_likelihood.clear()
    <Redacted>
    for entry in entity:
        resource = entry["resource"]
        if resource["resourceType"] == "Patient":
            state = resource["address"][0]["state"]
            print(state)
            birth_date = date.fromisoformat(resource["birthDate"])
            length_of_pregnancydict = resource["lengthOfPregnancy"][0]
            for key, value in length_of_pregnancydict.items():
                length_of_pregnancy = value
            diagnosis = resource["diagnosis"][0]
            for key, value in diagnosis.items():
                if value == "severe pre-eclipsia":
                    life_threat = True
                else:
                    life_threat = False
                if value == "trisomy 18":
                    no_fetus_survival = True
                else:
                    no_fetus_survival = False
                if value == "confirmed rape":
                    rape_related_pregnancy = True
                else:
                    rape_related_pregnancy = False
            break

    #to get the age of the LPR
    today = date.today()
    age = today.year - birth_date.year
    #What the User will input 
    

    # First it will find the state corresponding to which state the LPR lives 
    # The my_state method will calculate the LPR's home state likelihood seprate from the sorted dictionary
    # The other state's methods will calculate their likelihoods and will be stored in the state_likelihoods dictionary and sorted by value (highest % to lowest %)
    if state == "texas":
        required_length_of_pregnancy = 6
        ms_rape_related_pregnancy = False
        ms_no_fetus_survival = False
        my_state(age, life_threat, ms_rape_related_pregnancy, ms_no_fetus_survival, length_of_pregnancy, required_length_of_pregnancy, state = "Texas")
                # LOP = 6 weeks or Less
                # 18 years and younger need consent 
                # Life Threatening Condition Exception = Allowed
                # Rape Related pregnancy Exception = Not Allowed
                # Fetus will Not Survive Exception = Not Allowed
        ohio(life_threat, length_of_pregnancy, state = "Ohio")
        indiana(life_threat, length_of_pregnancy, state = "Indiana")
        connecticut(life_threat, rape_related_pregnancy, length_of_pregnancy, state = "Connecticut")
        new_hampshire(life_threat, no_fetus_survival, length_of_pregnancy, state = "New Hampshire")
        south_carolina(life_threat, no_fetus_survival, rape_related_pregnancy, length_of_pregnancy, state = "South Carolina")

        
    elif state == "ohio":
        required_length_of_pregnancy = 6
        ms_rape_related_pregnancy = False
        ms_no_fetus_survival = False
        my_state(age, life_threat, ms_rape_related_pregnancy, ms_no_fetus_survival, length_of_pregnancy, required_length_of_pregnancy, state = "Ohio")
                # LOP = 6 weeks or Less
                # 18 years and younger need consent 
                # Life Threatening Condition Exception = Allowed
                # Rape Related pregnancy Exception = Not Allowed
                # Fetus will Not Survive Exception = Not Allowed 
        indiana(life_threat, length_of_pregnancy, state = "Indiana")
        texas(life_threat, length_of_pregnancy, state = "Texas")
        connecticut(life_threat, rape_related_pregnancy, length_of_pregnancy, state = "Conneticut")
        new_hampshire(life_threat, no_fetus_survival, length_of_pregnancy, state = "New Hampshire")
        south_carolina(life_threat, no_fetus_survival, rape_related_pregnancy, length_of_pregnancy, state = "South Carolina")
        
    elif state == "indiana":
        required_length_of_pregnancy = 22
        ms_rape_related_pregnancy = False
        ms_no_fetus_survival = False
        my_state(age, life_threat, ms_rape_related_pregnancy, ms_no_fetus_survival, length_of_pregnancy, required_length_of_pregnancy, state = "Indiana")
                # LOP = 22 weeks or Less
                # 18 years and younger need consent 
                # Life Threatening Condition Exception = Allowed
                # Rape Related pregnancy Exception = Not Allowed
                # Fetus will Not Survive Exception = Not Allowed
        ohio(life_threat, length_of_pregnancy, state = "Ohio")
        texas(life_threat, length_of_pregnancy, state = "Texas")
        connecticut(life_threat, rape_related_pregnancy, length_of_pregnancy, state = "Connecticut")
        new_hampshire(life_threat, no_fetus_survival, length_of_pregnancy, state = "New Hampshire")
        south_carolina(life_threat, no_fetus_survival, rape_related_pregnancy, length_of_pregnancy, state = "South Carolina")
        
    elif state == "connecticut":
        required_length_of_pregnancy = 25
        ms_no_fetus_survival = False
        my_state(age, life_threat, rape_related_pregnancy, ms_no_fetus_survival, length_of_pregnancy, required_length_of_pregnancy, state = "Connecticut")
                # LOP = validity 23 - 26 weeks 
                # 16 years and younger need consent 
                # Life Threatening Condition Exception = Allowed
                # Rape Related pregnancy Exception = Allowed
                # Fetus will Not Survive Exception = Not Allowed
        ohio(life_threat, length_of_pregnancy, state = "Ohio")
        indiana(life_threat, length_of_pregnancy, state = "Indiana")
        texas(life_threat, length_of_pregnancy, state = "Texas")
        new_hampshire(life_threat, no_fetus_survival, length_of_pregnancy, state = "New Hampshire")
        south_carolina(life_threat, no_fetus_survival, rape_related_pregnancy, length_of_pregnancy, state = "South Carolina")
        
    elif state == "new hampshire":
        required_length_of_pregnancy = 24
        ms_rape_related_pregnancy = False
        my_state(age, life_threat, ms_rape_related_pregnancy, no_fetus_survival, length_of_pregnancy, required_length_of_pregnancy, state = "New Hampshire")
                # LOP = 24 weeks 
                # 18 years and younger need consent 
                # Life Threatening Condition Exception = Allowed
                # Rape Related pregnancy Exception = Not Allowed
                # Fetus will Not Survive Exception = Allowed
        ohio(life_threat, length_of_pregnancy, state = "Ohio")
        indiana(life_threat, length_of_pregnancy, state = "Indiana")
        texas(life_threat, length_of_pregnancy, state = "Texas")
        connecticut(life_threat, rape_related_pregnancy, length_of_pregnancy, state = "Connecticut")
        south_carolina(life_threat, no_fetus_survival, rape_related_pregnancy, length_of_pregnancy, state = "South Carolina")
        
    elif state == "south carolina":
        required_length_of_pregnancy = 6
        my_state(age, life_threat, rape_related_pregnancy, no_fetus_survival, length_of_pregnancy, required_length_of_pregnancy, state = "South Carolina")
                # LOP = 6 weeks 
                # 17 years and younger need consent 
                # Life Threatening Condition Exception = Allowed
                # Rape Related pregnancy Exception = Allowed
                # Fetus will Not Survive Exception = Allowed
        ohio(life_threat, length_of_pregnancy, state = "Ohio")
        indiana(life_threat, length_of_pregnancy, state = "Indiana")
        texas(life_threat, length_of_pregnancy, state = "Texas")
        connecticut(life_threat, rape_related_pregnancy, length_of_pregnancy, state = "Connecticut")
        new_hampshire(life_threat, no_fetus_survival, length_of_pregnancy, state = "New Hampshire")
    
    #This will sort the state_likelihoods dictionary
    sorted_tuples = sorted(state_likelihoods.items(), key=lambda item: item[1], reverse = True)
    
    risk_score = sorted_tuples
    likelihood_display = sorted(my_state_likelihood.items(), key=lambda item: item[1], reverse = True)
    # This for loop will print out the sorted dictionary and if the LPR needs parental consent 
    for i in sorted_tuples:
        LikelihoodCalc(i[0], i[1])
        Parental_Consent(i[0], age)


    risk_assessment: FHIR_RiskAssessment = { <REDACTED>}

   

    bundle: FHIR_Bundle = {REDACTED}

    return HealthAppResponse(
        insights=[
            Insight(
                summary=f"Likelihood of Getting an Abortion in the United States",
                detail=f"Click an look at each states likelihoods",
                resource=bundle,
                consult_ui=ConsultUI(
                    label="View Details",
                    context=json.dumps(
                        {
                           "display": likelihood_display,
                            "riskScore": risk_score,

                        }
                    ),
                ),
            ),
        ]
    )


if __name__ == "__main__":  # pragma: nocover
    logging.basicConfig(level=logging.INFO)
    Server(get_insights=get_insights).start_server(wait=True) 
# These are the specific state methods that will calculate the likelihood which starts at 0 and with every exception the LPR has the likelihood increases
# Each State's likelihood and state name is then sent to the LiklihoodDict method below 

def texas(lTC, lOP, state):

    likelihood = 0 #Maybe start them off with different likelihoods based on their bans
    if lOP < 6:
        likelihood = likelihood + ((6 - lOP) / 10)

    if lTC == True: 
        likelihood += .4
    
    
    LikelihoodDict(likelihood, state)

def ohio(lTC, lOP, state):

    likelihood = 0
    if lOP < 6:
        likelihood = likelihood + ((6 - lOP) / 10)

    if lTC == True: 
        likelihood += .2
    
    LikelihoodDict(likelihood, state)
    
def indiana(lTC, lOP, state):

    likelihood = 0
    if lOP < 22:
        likelihood = likelihood + ((22 - lOP) / 10)
    
    if lTC == True: 
        likelihood += .4
    
    LikelihoodDict(likelihood, state)

def connecticut(lTC, rRP, lOP, state):

    likelihood = 0
    if lOP < 25:
        likelihood = likelihood + ((25 - lOP) / 10)
    if lTC == True: 
        likelihood += .4
    if rRP == True: 
        likelihood += .2
    
    LikelihoodDict(likelihood, state)

def new_hampshire(lTC, nFS, lOP, state):

    likelihood = 0
    if lOP < 24:
        likelihood = likelihood + ((24 - lOP) / 10)

    elif lTC == True:
        likelihood += .4
    elif nFS == True:
        likelihood += .2
        
    LikelihoodDict(likelihood, state)

def south_carolina(lTC, nFS, rRP, lOP, state):

    likelihood = 0
    if lOP < 6:
        likelihood = likelihood + ((6 - lOP) / 10)
    if lTC == True: 
        likelihood += .4
    if nFS == True: 
        likelihood += .3
    if rRP == True: 
        likelihood += .2
        
    LikelihoodDict(likelihood, state)



# This method multiplies the likelihood values by 100 and then adds them to the state_likelihoods dictionary(Key = states, values = likelihood)   
def LikelihoodDict(likelihood, state):
    
    likelihood *= 100

    state_likelihoods[state] = likelihood

# This Method is for the home states because I wanted them seperate from the dictionary
# it does the same thing the "states" go through, the only difference is that they are not added to the dictionary 
def my_state(age, lTC, rRP, nFS, lOP, rLOP, state):
    stateOutput = "YOUR STATE " + state
    likelihood = 0
    if lOP < rLOP:
        likelihood = likelihood + ((rLOP - lOP) / 10)
    if lTC == True: 
        likelihood += .3
    if nFS == True: 
        likelihood += .3
    if rRP == True: 
        likelihood += .2
    
        
    likelihood *= 100

    my_state_likelihood[state] = likelihood
    
    LikelihoodCalc(stateOutput, likelihood)
    Parental_Consent(state, age)


# Will print out the % of each state
def LikelihoodCalc(state, likelihood):

    if likelihood > 100:
        print("\nThe likelihood of getting an Abortion in", state, "is 100%")
    elif likelihood < 0:
        print("\nThe likelihood of getting an Abortion in", state, "is 0%")
    else:
        print("\nThe likelihood of getting an Abortion in", state, "is", '%.1f' % likelihood, "%")

# If they are from a state AND they are below the specified age, they will be notified that they need parental consent
# Else: they do not need it 
def Parental_Consent(state, age):
    if state == "Texas" and age < 18:
        print("Needs Parental Consent: From one parent and sepreatly notfiy a parent 48 hours prior")
    elif state == "Connecticut" and age < 16:
        print("Needs counseling from a nurse or clinician")
    elif state == "South Carolina" and age < 17:
        print("Needs Parental Consent: From a parent or grandparent")
    elif state == "New Hampshire" and age < 18:
        print("Needs Parental Consent: Notfiy parent 48 hours prior")
    elif state == "Ohio" and age < 18:
        print("Needs Parental Consent: From parent or legal guardian")
    elif state == "Indiana" and age < 18:
        print("Needs Parental Consent: From one of your parents")
    else:
        print("No Parental Consent Needed")
