class Event:
    def __init__(self):
        self.events = dict()
        self.evID = 0

    def addNewEvent(self, eventYear, eventMonth, eventDay,
                    eventTime, eventType, eventDuration,
                    eventDescription):
        event = [eventYear, eventMonth, eventDay,
                 eventTime, eventType, eventDuration,
                 eventDescription]
        self.events[self.evID] = event
        self.evID += 1

    def printEventsbyMonth(self, eventYear, eventMonth):
        if len(self.events) == 0:
            print('События отсутствуют\n')
            return
        print('{0} {1}'.format('События: ', self.getMonthNameByNumber
                               (
                                   month=eventMonth,
                                   year=eventYear
                               )).center(30, '~'))
        for key, evlist in self.events.items():
            if isinstance(evlist, list):
                if evlist[0] == eventYear and evlist[1] == eventMonth:
                    print('ID события-{0}: {1} на {2}/{3}/{4} в {5} продолжительностью {6}.'
                          .format(key, evlist[4],
                                  evlist[0], evlist[1],
                                  evlist[2], evlist[3],
                                  evlist[5]
                                  ))
                    print('Описание: {0}'.format(evlist[6]))
                    print('\n')

    def printEventsbyDay(self, eventYear, eventMonth, eventDay):
        if len(self.events) == 0:
            print('События не найдены\n')
            return
        print('{0} {1} {2}'.format('События: ', self.getMonthNameByNumber
                                   (
                                       month=eventMonth, year=eventYear
                                   ),
                                   eventDay).center(30, '~'))
        for key, evlist in self.events.items():
            if isinstance(evlist, list):
                if evlist[0] == eventYear and evlist[1] == eventMonth and evlist[2] == eventDay:
                    print('ID события -{0}: {1} на {2}/{3}/{4} в {5} продолжительностью {6}.'
                          .format(key, evlist[4],
                                  evlist[0], evlist[1],
                                  evlist[2], evlist[3],
                                  evlist[5]))
                    print('События: {0}'.format(evlist[6]))
                    print('\n')

    def delEvent(self, eventYear, eventMonth, eventDay, eventTime, eventDuration):
        if len(self.events) == 0:
            print('События не найдены\n')
            return
        print('Удаление события')
        for key, evlist in self.events.items():
            if isinstance(evlist, list):
                if evlist[0] == eventYear and evlist[1] == eventMonth and evlist[2] == eventDay:
                    if evlist[3] == eventTime and evlist[5] == eventDuration:
                        self.events.pop(key)
                        print('Удалено')
                        break

    def delEventByID(self, eventID):
        if len(self.events) == 0:
            print('События не найдены\n')
            return
        if self.events.get(eventID) != None:
            self.events.pop(eventID)
        else:
            print('Данный ID отсутствует')

    # Used for updating event in the user interface
    def getEventByID(self, eventID):
        if self.events.get(eventID) == None:
            return 'ID события отсутствует'
        return list(self.events.get(eventID))

    def updateEvent(self, eventID, evYear, evMonth, evDay, evTime, evType, evDuration, evDescription):
        if len(self.events) == 0:
            print('События не найдены\n')
            return
        self.events[eventID] = [evYear, evMonth, evDay,
                                evTime, evType, evDuration, evDescription]

    def updateEventByDay(self, eventYear, eventMonth, eventDay, eventTime, eventDuration):
        if len(self.events) == 0:
            print('События не найдены\n')
            return
        for key in self.events.keys():
            if isinstance(self.events.get(key), list):
                evList = list(self.events.get(key))
                if evList[0] == eventYear and evList[1] == eventMonth and evList[2] == eventDay:
                    self.printEventsbyDay(eventYear, eventMonth, eventDay)
                    eventID = int(input('Введите ID события: '))
                    if key+1 == eventID:
                        evList[0] = int(input('Изменить год: '))
                        evList[1] = int(input('Изменить месяц: '))
                        evList[2] = int(input('Изменить день: '))
                        evList[3] = str(input('Изменить время: '))
                        evList[4] = str(input('Изменить название: '))
                        evList[5] = str(input('Изменить продолжительность: '))
                        evList[6] = str(input('Изменить описание: '))

    def getMonthNameByNumber(self, year, month):
        from Calendar import Calendar
        cal = Calendar()
        cal.printMonth(month=month, year=year)
        return cal.months[month]

    def getAllEventsDatesByMonth(self):
        if len(self.events) == 0:
            print('События отсутствуют\n')
            return
        print('Все даты с событиями ГГГГ/ММ/ДД')
        months = set()
        for key, evlist in self.events.items():
            months.add((evlist[0], evlist[1]))
        for year, month in months:
            print('>> {0}/{1}\n'.format(year, month))

    def getAllEventsDatesByDay(self):
        if len(self.events) == 0:
            print('События отсутствуют\n')
            return
        print('Все даты с событиями ГГГГ/ММ/ДД')
        months = set()
        for key, evlist in self.events.items():
            months.add((evlist[0], evlist[1], evlist[2]))
        for year, month, day in months:
            print('>> {0}/{1}/{2}\n'.format(year, month, day))

    def printAllEvents(self):
        if len(self.events) == 0:
            print('События отсутствуют\n')
            return
        print('Все события')
        for key, evlist in self.events.items():
            print('ID события -{0}: {1} на {2}/{3}/{4} в {5} продолжительностью {6}.'
                  .format(key, evlist[4],
                          evlist[0], evlist[1],
                          evlist[2], evlist[3],
                          evlist[5]))
            print('Описание: {0}'.format(evlist[6]))
            print('\n')

    def isEmpty(self):
        isEmpty = False
        if len(self.events != 0):
            isEmpty = False
        else:
            isEmpty = True
        return isEmpty

    def getEvents(self):
        return self.events
