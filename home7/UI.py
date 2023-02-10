from Calendar import Calendar
from Event import Event
import os


class UserInterface:

    def __init__(self):
        self.calendar = Calendar()
        self.events = Event()
        self.day = int()
        self.month = int()
        self.year = int()
        self.eventID = int()

    def clear_console(self):
        command = 'clear'
        if os.name in ('nt', 'dos'):  # If Machine is running on Windows, use cls
            command = 'cls'
        os.system(command)

    def menu(self):
        print('1 -> Вывести календарь года (от 1900 до 2033)')
        print('2 -> Вывести календарь месяца (1 - 12)')
        print('3 -> Вывести все события')
        print('4 -> Вывести месяца с событиями')
        print('5 -> Вывести дни с событиями')
        print('6 -> Завершить программу')

        option = int(input('\nВыберите операцию: '))

        if option == 1:
            self.print_calendar_year()
        elif option == 2:
            self.print_month()
        elif option == 3:
            self.print_all_events()
        elif option == 4:
            self.print_month_event()
        elif option == 5:
            self.print_day_event()
        elif option == 6:
            return
        else:
            self.clear_console()
            self.menu()

    def event_menu(self):
        print('1 - Добавить новое событие?')
        print('2 - Изменить событие?')
        print('3 - Удалить событие?')
        print('0 - Главное меню')
        option = int(input('\n Выберите операцию: '))
        if option == 1:
            self.add_new_event()
        elif option == 2:
            self.change_event()
        elif option == 3:
            self.del_event()
        elif option == 0:
            self.menu()

    def events_menu(self):
        print('1 - Изменить событие?')
        print('0 - Главное меню')
        opt = int(input('\nВыберите операцию: '))
        if opt == 0:
            self.menu()
        elif opt == 1:
            self.event_menu()
        else:
            print(
                'Некорректный ввод!')
            self.events_menu()

    def print_calendar_year(self):
        year = int(input('\nВведите год (1900 - 2033): \n'))
        self.calendar.print_calendar_year(int(year))
        self.main_menu()

    def print_month(self):
        year = int(input('\nВведите год (1900 - 2033): \n'))
        month = int(input('\nВведите месяц (1 - 12): \n'))
        self.calendar.print_month(int(year), int(month))
        self.main_menu()

    def print_day_event(self):
        self.events.get_all_events_dates_day()
        self.year = int(input('\nВведите год (1900 - 2033): \n'))
        self.month = int(input('\Введите месяц (1 - 12): \n'))
        self.day = int(input('\nВведите число: \n'))
        self.events.print_events_day(
            int(self.year), int(self.month), int(self.day))
        self.events_menu()

    def print_month_event(self):
        self.events.get_all_events_dates_month()
        self.year = int(input('\nВведите год (1900 - 2033): \n'))
        self.month = int(input('\nВведите месяц (1 - 12): \n'))
        self.events.print_events_month(int(self.year), int(self.month))
        self.events_menu()
        self.event_menu()

    def add_new_event(self):
        year = int(input('\nВведите год нового события (1900 - 2033): \n'))
        month = int(input('\nВведите месяц нового события (1 - 12): \n'))
        day = int(input('\nВведите день нового события: \n'))
        time = str(input('\nВведите время нового события: \n'))
        type = str(input('\nВведите название нового события: \n'))
        duration = str(
            input('\nВведите продолжитеьность нового события: \n'))
        descr = str(input('\nВведите описание нового события: \n'))
        self.events.add_new_event(eventYear=int(year), eventMonth=int(month),
                                  eventDay=int(day), eventTime=str(time), eventType=str(type),
                                  eventDuration=str(duration), eventDescription=str(descr))
        print('событие добавлено\n')
        self.main_menu()

    def change_event(self):
        eventID = int(input('\nПожалуста введите ID события: '))
        eventList = list(self.events.get_event_id(eventID))
        print('1 - Изменить год, месяц или день?')
        print('2 - Изменить время?')
        print('3 - Изменить название?')
        print('4 - Изменить описание?')
        print('5 - Изменить продолжительность?')
        print('6 - Изменить все элементы событий?')
        print('0 - Главное меню')
        option = int(input('\nВведите число: '))
        if option == 1:
            year = int(input('\nВведите новый год (1900 - 2033): '))
            month = int(input('\nВведите новй месяц (1 - 12): '))
            day = int(input('\nВведите новый день: '))
            self.events.change_event(eventID=eventID, evYear=year, evMonth=month,
                                     evDay=day, evType=eventList[4], evTime=eventList[3],
                                     evDuration=eventList[5], evDescription=eventList[6])
            print('событие обновлено')
            self.main_menu()
        elif option == 2:
            time = str(input('\nВведите время: '))
            self.events.change_event(eventID=eventID, evYear=eventList[0], evMonth=eventList[1],
                                     evDay=eventList[2], evType=eventList[4], evTime=time,
                                     evDuration=eventList[5], evDescription=eventList[6])
            print('событие обновлено')
            self.main_menu()
        elif option == 3:
            type = str(input('\nВведите название: '))
            self.events.change_event(eventID=eventID, evYear=eventList[0], evMonth=eventList[1],
                                     evDay=eventList[2], evType=type, evTime=eventList[3],
                                     evDuration=eventList[5], evDescription=eventList[6])
            print('событие обновлено')
            self.main_menu()
        elif option == 4:
            duration = str(input('\nВведите описание: '))
            self.events.change_event(eventID=eventID, evYear=eventList[0], evMonth=eventList[1],
                                     evDay=eventList[2], evType=eventList[4], evTime=eventList[3],
                                     evDuration=duration, evDescription=eventList[6])
            print('событие обновлено')
            self.main_menu()
        elif option == 5:
            description = str(input('\nВведите продолжительность: '))
            self.events.change_event(eventID=eventID, evYear=eventList[0], evMonth=eventList[1],
                                     evDay=eventList[2], evType=eventList[4], evTime=eventList[3],
                                     evDuration=eventList[5], evDescription=description)
            print('событие обновлено')
            self.main_menu()
        elif option == 6:
            year = int(input('\nВведите новый год (1900 - 2033): '))
            month = int(input('\nВведите новый месяц (1 - 12): '))
            day = int(input('\nВведите новый день: '))
            time = str(input('\nВведите новое время: '))
            type = str(input('\nПридумайте название события: '))
            duration = str(input('\nОпишите событие: '))
            description = str(input('\nВведите новую продолжительность: '))
            self.events.change_event(eventID=eventID, evYear=year, evMonth=month, evDay=day,
                                     evDescription=description, evDuration=duration,
                                     evTime=time, evType=type)
            print('событие обновлено')
            self.main_menu()
        else:
            self.main_menu()

    def print_all_events(self):
        if len(self.events.get_events()) == 0:
            print('Событие не обнаружено')
            print('Добавить новое событие?')
            print('\n1 - Да'
                  '\n2 - Нет'
                  '\n0 - главное меню')
            option = int(input('\nВыберите операцию: '))
            if option == 0:
                return self.menu()
            elif option == 1:
                return self.add_new_event()
            else:
                self.main_menu()
        else:
            self.events.print_all_events()
            self.main_menu()

    def del_event(self):
        self.events.print_all_events()
        eventID = int(input('для удаления введите ID события: '))
        self.events.del_event_by_id(eventID)
        self.main_menu()

    def main_menu(self):
        print('0 - главное меню')
        userIn = int(input('\nВыберите операцию:\n'))
        if userIn == 0:
            self.clear_console()
            self.menu()
        else:
            print('некорректная операция\n')
            self.main_menu()
