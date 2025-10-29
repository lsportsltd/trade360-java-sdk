package com.lsports.trade360_java_sdk.customers_api;

import com.lsports.trade360_java_sdk.common.http.ApiRestClient;
import com.lsports.trade360_java_sdk.customers_api.entities.subscription_api.base.CompetitionSubscription;
import com.lsports.trade360_java_sdk.customers_api.entities.subscription_api.base.LeagueSubscription;
import com.lsports.trade360_java_sdk.customers_api.entities.subscription_api.base.Suspension;
import com.lsports.trade360_java_sdk.customers_api.entities.subscription_api.requests.*;
import org.junit.Test;
import java.util.Arrays;
import java.util.List;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class SubscriptionApiClientImplementationTests {

    @Test
    public void getPackageQuota_parameterlessCalledWithCorrectUrl_callsCorrectUrl(){
        //Arrange

        var mockedClient = mock(ApiRestClient.class);
        var client = new SubscriptionApiClientImplementation(mockedClient);

        //Act
        client.getPackageQuota();

        //Assert
        verify(mockedClient).postRequest(any(), eq("/package/GetPackageQuota") );
    }

    @Test
    public void getInPlayFixtureSchedule_parameterlessCalledWithCorrectUrl_callsCorrectUrl(){
        //Arrange

        var mockedClient = mock(ApiRestClient.class);
        var client = new SubscriptionApiClientImplementation(mockedClient);
        List<Integer> dumpList = Arrays.asList(1,2);
        var request = new GetFixtureScheduleRequest(dumpList, dumpList, dumpList );

        //Act
        client.getInPlayFixtureSchedule(request);

        //Assert
        verify(mockedClient).postRequest(any(), any(), eq("Fixtures/InPlaySchedule") );
    }

    @Test
    public void subscribeByFixture_parameterlessCalledWithCorrectUrl_callsCorrectUrl(){
        //Arrange

        var mockedClient = mock(ApiRestClient.class);
        var client = new SubscriptionApiClientImplementation(mockedClient);
        List<Integer> dumpList = Arrays.asList(1,2);
        var request = new FixtureSubscriptionRequest(dumpList);

        //Act
        client.subscribeByFixture(request);

        //Assert
        verify(mockedClient).postRequest(any(), any(), eq("Fixtures/Subscribe"));
    }

    @Test
    public void unSubscribeByFixture_parameterlessCalledWithCorrectUrl_callsCorrectUrl(){
        //Arrange

        var mockedClient = mock(ApiRestClient.class);
        var client = new SubscriptionApiClientImplementation(mockedClient);
        List<Integer> dumpList = Arrays.asList(1,2);
        var request = new FixtureSubscriptionRequest(dumpList);

        //Act
        client.unSubscribeByFixture(request);

        //Assert
        verify(mockedClient).postRequest(any(), any(), eq("Fixtures/UnSubscribe"));
    }

    @Test
    public void subscribeByLeague_parameterlessCalledWithCorrectUrl_callsCorrectUrl(){
        //Arrange

        var mockedClient = mock(ApiRestClient.class);
        var client = new SubscriptionApiClientImplementation(mockedClient);
        List<LeagueSubscription> leagueSubscriptions = Arrays.asList(new LeagueSubscription(1,1,1));
        var request = new LeagueSubscriptionRequest(leagueSubscriptions);

        //Act
        client.subscribeByLeague(request);

        //Assert
        verify(mockedClient).postRequest(any(), any(), eq("Leagues/Subscribe"));
    }

    @Test
    public void unSubscribeByLeague_parameterlessCalledWithCorrectUrl_callsCorrectUrl(){
        //Arrange

        var mockedClient = mock(ApiRestClient.class);
        var client = new SubscriptionApiClientImplementation(mockedClient);
        List<LeagueSubscription> leagueSubscriptions = Arrays.asList(new LeagueSubscription(1,1,1));
        var request = new LeagueSubscriptionRequest(leagueSubscriptions);

        //Act
        client.unSubscribeByLeague(request);

        //Assert
        verify(mockedClient).postRequest(any(), any(), eq("Leagues/UnSubscribe"));
    }

    @Test
    public void getSubscriptions_parameterlessCalledWithCorrectUrl_callsCorrectUrl(){
        //Arrange

        var mockedClient = mock(ApiRestClient.class);
        var client = new SubscriptionApiClientImplementation(mockedClient);
        List<Integer> dumpList = Arrays.asList(1,2);
        var request = new GetSubscriptionRequest(dumpList,dumpList,dumpList);

        //Act
        client.getSubscriptions(request);

        //Assert
        verify(mockedClient).postRequest(any(), any(), eq("Fixtures/Get") );
    }

    @Test
    public void subscribeByCompetition_parameterlessCalledWithCorrectUrl_callsCorrectUrl(){
        //Arrange

        var mockedClient = mock(ApiRestClient.class);
        var client = new SubscriptionApiClientImplementation(mockedClient);
        List<CompetitionSubscription> leagueSubscriptions = Arrays.asList(new CompetitionSubscription(1,1,1));
        var request = new CompetitionSubscriptionRequest(leagueSubscriptions);

        //Act
        client.subscribeByCompetition(request);

        //Assert
        verify(mockedClient).postRequest(any(), any(), eq("Outright/Subscribe"));
    }

    @Test
    public void unSubscribeByCompetition_parameterlessCalledWithCorrectUrl_callsCorrectUrl(){
        //Arrange

        var mockedClient = mock(ApiRestClient.class);
        var client = new SubscriptionApiClientImplementation(mockedClient);
        List<CompetitionSubscription> leagueSubscriptions = Arrays.asList(new CompetitionSubscription(1,1,1));
        var request = new CompetitionSubscriptionRequest(leagueSubscriptions);

        //Act
        client.unSubscribeByCompetition(request);

        //Assert
        verify(mockedClient).postRequest(any(), any(), eq("Outright/UnSubscribe"));
    }

    @Test
    public void getAllManualSuspensions_parameterlessCalledWithCorrectUrl_callsCorrectUrl(){
        //Arrange

        var mockedClient = mock(ApiRestClient.class);
        var client = new SubscriptionApiClientImplementation(mockedClient);

        //Act
        client.getAllManualSuspensions();

        //Assert
        verify(mockedClient).postRequest( any(), eq("Markets/ManualSuspension/GetAll"));
    }

    @Test
    public void addManualSuspension_parameterlessCalledWithCorrectUrl_callsCorrectUrl(){
        //Arrange

        var mockedClient = mock(ApiRestClient.class);
        var client = new SubscriptionApiClientImplementation(mockedClient);
        var suspension = new Suspension(true, 1, 2, 3, 4, java.time.LocalDateTime.now(), null);
        List<Suspension> suspensions = Arrays.asList(suspension);
        var request = new ChangeManualSuspensionRequest(suspensions);

        //Act
        client.addManualSuspension(request);

        //Assert
        verify(mockedClient).postRequest(any(), any(), eq("Markets/ManualSuspension/Activate"));
    }

    @Test
    public void removeManualSuspension_parameterlessCalledWithCorrectUrl_callsCorrectUrl(){
        //Arrange

        var mockedClient = mock(ApiRestClient.class);
        var client = new SubscriptionApiClientImplementation(mockedClient);
        var suspension = new Suspension(true, 1, 2, 3, 4, java.time.LocalDateTime.now(), null);
        List<Suspension> suspensions = Arrays.asList(suspension);
        var request = new ChangeManualSuspensionRequest(suspensions);

        //Act
        client.removeManualSuspension(request);

        //Assert
        verify(mockedClient).postRequest(any(), any(), eq("Markets/ManualSuspension/Deactivate"));
    }


}
